package com.tusheng.oa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbsenceBean {
	
	private int id;
	private int user_id;
	private Date start_time;
	private Date end_time;
	private int status;
	private Date created_at;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	public void inAbsence(int userid,String start_time,String end_time) {
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowdate = format.format(d);
		String s = "insert into absence set user_id =\"" + userid + "\", start_time= \"" 
					+ start_time + "\",end_time=\"" + end_time +"\",status=1,created_at =\"" + nowdate + "\"";
		db.insert(s);
		db.close();
	}
	
	public ResultSet getAbsence(int userid){
		DB db=new DB();
		String sql="select absence from user where user_id=\""+
				userid+"\"";
		ResultSet rs=db.select(sql);
		return rs;
		
	}
	

}


