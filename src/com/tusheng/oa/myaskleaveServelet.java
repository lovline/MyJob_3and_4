package com.tusheng.oa;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class myaskleaveServelet
 */
@WebServlet("/myaskleave")
public class myaskleaveServelet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myaskleaveServelet() {
        super();
        // TODO Auto-generated constructor stub
        this.setTitle("我的请假记录");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see com.tusheng.oa.BaseServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("is_logged", true);
		
		String start_time=request.getParameter("start_time");
		String application_start=request.getParameter("application_start");
		String end_time=request.getParameter("end_time");
		//String username=(String) session2.getAttribute("username");错误的写法
		//String password=(String) session.getAttribute("password");
		System.out.println(session.getAttribute("username").toString());
		System.out.println(session.getAttribute("password").toString());
		String type=request.getParameter("select");
		String remark=request.getParameter("remark");
		
		session.setAttribute("user_name", session.getAttribute("username").toString());
		
	    AbsenceBean abb=new AbsenceBean();
	   
	    UserBean bean=new UserBean();
	    boolean flag=bean.login(session.getAttribute("username").toString(),session.getAttribute("password").toString());
	    if(flag){
	    	int userid=bean.getId();
	    	System.out.println(userid);
	    	abb.inAbsence(userid, start_time, end_time,type,remark);
			session.setAttribute("userid", userid);
			//遍历数据库absence的数据
			ArrayList<AbsenceBean> arrList=abb.getAbsence(userid);
		    //request.setAttribute("arrList", arrList);
			session.setAttribute("arrList", arrList);
			//session.setAttribute("arrListNotInData", arrList.get(1));
		    request.getRequestDispatcher("/myaskleave.jsp").forward(request, response);
		    for(AbsenceBean ab: arrList){
		    	System.out.println(ab.getStart_time());
		    }
	    }
	}

	    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	   
	}

}
