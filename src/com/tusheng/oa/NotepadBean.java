package com.tusheng.oa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class NotepadBean {

	private int user_id;
	private int notepad_id;
	private String title;
	private String content;
	private Date create_time;
	private Date last_edit_time;
	private boolean tinyint;
	
	public ResultSet show_info()
	{
		DB db=new DB();
		String sql = "select * from notepad ";
		ResultSet rs = db.select(sql);
		try {
			if(rs.next())
			{
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert()
	{
		boolean flag = false;
		return flag;
	}
	
	public boolean updata()
	{
		boolean flag = false;
		return flag;
	}
	
	public boolean add()
	{
		boolean flag = false;
		return flag;
	}
	
	public int getNotepad_id() {
		return notepad_id;
	}

	public void setNotepad_id(int notepad_id) {
		this.notepad_id = notepad_id;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_edit_time() {
		return last_edit_time;
	}
	public void setLast_edit_time(Date last_edit_time) {
		this.last_edit_time = last_edit_time;
	}
	public boolean isTinyint() {
		return tinyint;
	}
	public void setTinyint(boolean tinyint) {
		this.tinyint = tinyint;
	}	
}
