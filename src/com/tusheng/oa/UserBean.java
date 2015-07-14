package com.tusheng.oa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class UserBean {
	private int id;
	private String username;
	private String password;
	private int status;
	private boolean is_active;
	private String realname;
	private Date last_login_at;
	private Date created_at;
	
	
	public boolean register(String username,String password,String realname){
		DB db=new DB();
		String sql="select id from user where username=\""+
				username+"\"";
		System.out.println(username);
		System.out.println(sql);
		ResultSet rs=db.select(sql);
		try {
			if(rs.next()){
				return false;
			}else{
				String s="insert into user set username=\""+
				username+"\",password=\""+password+"\",realname=\""+realname+"\"";
				db.insert(s);
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		 
	}
	
	
	public boolean login(String username,String password){
		DB db = new DB();
		String sql = "select * from user where username=\""+ username + "\" and password=\""+password+"\"";
		ResultSet rs = db.select(sql);
		try {
			if (rs.next()){
				Date d = new Date();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowdate = format.format(d);
				String s = "update user set status=1,is_active=1,created_at =\"" + nowdate + "\" where username=\""+username+"\"";
				db.insert(s);
				this.id = rs.getInt("id");
				this.is_active = rs.getInt("is_active") == 1;
				System.out.println(this.is_active);
				this.realname = rs.getString("realname");
				this.created_at = rs.getDate("created_at");
				this.last_login_at = rs.getDate("last_login_at");
				db.close();
				return true;
			}
			db.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.close();
			return false;
		}
	}
	
	public boolean login(int id){
		DB db = new DB();
		String sql = "select * from user where id="+id;
		ResultSet rs = db.select(sql);
		try {
			if (rs.next()){
				this.id = rs.getInt("id");
				this.is_active = rs.getInt("is_active") == 1;
				this.status = rs.getInt("status");
				this.realname = rs.getString("realname");
				this.created_at = rs.getDate("created_at");
				this.last_login_at = rs.getDate("last_login_at");
				db.close();
				return true;
			}
			db.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.close();
			return false;
		}
	}
	
	// setter and getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Date getLast_login_at() {
		return last_login_at;
	}
	public void setLast_login_at(Date last_login_at) {
		this.last_login_at = last_login_at;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
}
