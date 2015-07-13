package com.tusheng.oa;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        this.setTitle("途晟科技登陆");
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
		String jsp = "/login.jsp";
		RequestDispatcher dispacher = request.getRequestDispatcher(jsp);
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBean bean = new UserBean();
		bean.setUsername(username);
		bean.setPassword(password);
		request.setAttribute("userBean", bean);
		boolean is_succ = bean.login();
		if (is_succ){
			HttpSession session = request.getSession();
			session.setAttribute("is_logged", true);
			session.setAttribute("userid", bean.getId());
			response.sendRedirect(request.getContextPath() + "/index");
		}
		else{
			String alert = URLEncoder.encode("登陆失败，请正确填写用户名和秘密", "utf-8");
			response.sendRedirect(request.getContextPath() + "/login?alert"+alert);
			return;
		}
	}

}
