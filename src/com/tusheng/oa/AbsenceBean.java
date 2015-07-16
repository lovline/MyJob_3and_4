package com.tusheng.oa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AbsenceBean {
	
	private int id;
	private int user_id;
	private String start_time;
	private String end_time;
	private int status;
	private String created_at;
	private int days;
	private String username;
	private String remark;
	private String auditor;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	private String application_start;

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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Timestamp getApplication_start() {
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowdate = format.format(d);
		Timestamp date=Timestamp.valueOf(nowdate);
		return date;
	}

	public void setApplication_start(String application_start) {
		
	}

	public void inAbsence(int userid,String start_time,String end_time,String type,String remark) {
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowdate = format.format(d);
		System.out.println("************");
		System.out.println(nowdate.length());
		//nowdate=nowdate.substring(0, 10);
		Timestamp date=Timestamp.valueOf(nowdate);
		System.out.println(nowdate);
		String s = "insert into absence set user_id =\"" + userid + "\", start_time= \"" 
					+ start_time + "\",type= \"" + type + "\",remark= \"" 
					+ remark + "\",end_time=\"" + end_time +"\",status=1,created_at =\"" + nowdate + "\"";
		db.insert(s);
		db.close();
	}
	
	public ArrayList<AbsenceBean> getAbsence(int userid){
		DB db=new DB();
		String sql="select * from absence where user_id=\""+
				userid+"\"";
		ResultSet rs=db.select(sql);
		
		ArrayList<AbsenceBean> arrList=new ArrayList<AbsenceBean>();
	    if(rs != null){  
	        try {
	        	
	        	while(rs.next()){ 
	        		AbsenceBean abb=new AbsenceBean();
					abb.setEnd_time(rs.getString("end_time"));
					abb.setStart_time(rs.getString("start_time"));
					abb.setStatus(rs.getInt("status"));
					abb.setCreated_at(rs.getString("created_at"));
					abb.setType(rs.getString("type"));
					abb.setRemark(rs.getString("remark"));
					
					arrList.add(abb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
    	} 
	    
		return arrList;
		
	}
	
	public ArrayList<AbsenceBean> getAbsenceNotInDatabase(String application_start
			,String type,String remark,String username){
		
		ArrayList<AbsenceBean> arrList=new ArrayList<AbsenceBean>();
		AbsenceBean abb=new AbsenceBean();
		abb.setApplication_start(application_start);
		abb.setRemark(remark);
		abb.setType(type);
		abb.setUsername(username);
		arrList.add(abb);
 
		return arrList;
		
	}
	
	public int getDays() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date d1 = null;
        Date d2 = null;
        try {
			d1 = format.parse(start_time);
			d2 = format.parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long diff = d2.getTime() - d1.getTime();
        //long diffSeconds = diff / 1000 % 60;
        //long diffMinutes = diff / (60 * 1000) % 60;
        //long diffHours = diff / (60 * 60 * 1000) % 24;
        int days =(int)(diff / (24 * 60 * 60 * 1000));
	    System.out.println(days);
		
		return days;
	}
	
	
	

}


