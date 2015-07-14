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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		request.getRequestDispatcher("/myaskleave.jsp").forward(request, response);
		HttpSession session = request.getSession();
		session.setAttribute("is_logged", true);
		String start_time=request.getParameter("start_time");
		String application_start=request.getParameter("application_start");
		String end_time=request.getParameter("end_time");
		
		
		//String username=(String)request.getAttribute("username");都不行
		//String password=(String) request.getAttribute("password");
		//String username=(String) this.getServletContext().getAttribute("username");
		System.out.println(request.getSession().getAttribute("username"));
		
		
		String type=request.getParameter("select");
		String remark=request.getParameter("remark");
		//System.out.println(start_time);
		//System.out.println(type);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long days = diff / (24 * 60 * 60 * 1000);
	    System.out.println(days);
	    //System.out.println(username);
	    //先写到数据库里面去
	    //AbsenceBean abb=new AbsenceBean();
	    //UserBean bean=new UserBean();
	    //boolean flag=bean.login(username,password);
	    //if(flag){
	    //	int userid=bean.getId();
	    // 	System.out.println(userid);
	    // }
	   
	    //abb.inAbsence(userid, start_time, end_time);
	    
	    /*
	    //遍历数据库absence的数据
	    request.setAttribute("AbsenceBean", abb);
	    ArrayList<AbsenceBean> arrList=new ArrayList<AbsenceBean>();
	    ResultSet rs=abb.getAbsence(userid);
	    if(rs != null){  
	        try {
				do{  
					TableList tb=new TableList();
				
					tb.setApplication_start(new Date(application_start));
					tb.setAuditor("auditor");
					tb.setDays((int)days);
					tb.setRemark(remark);
					tb.setUsername(username);
					
					System.out.println(tb.getApplication_start());
					
				}while(rs.next());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    }  */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
