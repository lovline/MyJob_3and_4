package com.tusheng.oa;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NotepadListServlet
 */
@WebServlet("/notepadList/")
public class NotepadListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public NotepadListServlet() {
        super();
        this.setTitle("记事本列表");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		request.getRequestDispatcher("/notepadList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		super.doPost(request, response);
		NotepadBean notepadBean = new NotepadBean();
		ResultSet resultSet = notepadBean.show_info();
		ArrayList<NotepadBean> arrayList = new ArrayList<NotepadBean>();
		try {
			while(resultSet.next())
			{
				NotepadBean notepad = new NotepadBean();
				notepad.setNotepad_id(resultSet.getInt("notepad_id"));
				notepad.setTitle(resultSet.getString("title"));
				System.out.println(resultSet.getString("title"));
				notepad.setContent(resultSet.getString("content"));
				arrayList.add(notepad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("resultSet", arrayList);	
		request.getRequestDispatcher("/notepadList.jsp").forward(request, response);
	}

}
