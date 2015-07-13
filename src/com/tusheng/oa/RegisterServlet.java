package com.tusheng.oa;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        this.setTitle("途晟科技在线注册");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		String alert = request.getParameter("alert");
		boolean hasAlert = false;
		if (alert != null && !alert.isEmpty()){
			request.setAttribute("alert", alert);
			hasAlert = true;
		}
		request.setAttribute("hasAlert", hasAlert);
		request.setAttribute("alert", alert);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String realname=request.getParameter("realname");
		String password = request.getParameter("password");
		if(username==null || username.trim().isEmpty()){
			String alert = URLEncoder.encode("注册时用户名不能为空", "utf-8");
			String url = request.getContextPath()+ "/register?alert="+alert;
			response.sendRedirect(url);
			return;
		}else if(realname==null || realname.trim().isEmpty()){
			String alert = URLEncoder.encode("注册时真实名不能为空", "utf-8");
			String url = request.getContextPath()+ "/register?alert="+alert;
			response.sendRedirect(url);
			return;
		}
		else if(password == null || password.trim().isEmpty()){
			String alert = URLEncoder.encode("注册时密码不能为空", "utf-8");
			String url = request.getContextPath()+ "/register?alert="+alert;
			response.sendRedirect(url);
			return;
		}
		UserBean bean = new UserBean();
		boolean flag = bean.register(username, password,realname);
		//System.out.println("test...");
		if (flag){
			String alert = URLEncoder.encode("Registered Success , Please Log In", "utf-8");
			//String 
			String url = request.getContextPath()+ "/login?alert="+alert;
			response.sendRedirect(url);
			return;
		}  
		else{
			String alert = URLEncoder.encode("用户名已经存在，请重新注册", "utf-8");
			String url = request.getContextPath()+ "/register?alert="+alert;
			response.sendRedirect(url);
			return;
		}  
		
	}

}
