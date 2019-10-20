package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.DatabaseConnection;

/**
 * Servlet implementation class AssignTask
 */
@WebServlet("/AssignTask")
public class AssignTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int lid=(Integer)session.getAttribute("pid");
		int aid=Integer.parseInt(request.getParameter("aid"));

		String title=request.getParameter("title");
		String summary=request.getParameter("summary");
		Connection con=DatabaseConnection.getConnection();
		PrintWriter out =response.getWriter();

		try {
			PreparedStatement ps=con.prepareStatement("insert into tasks(title,summary,aid,status,lid) values(?,?,?,'in progress',?)");
			ps.setString(1,title);
			ps.setString(2, summary);
			ps.setInt(3, aid);
			ps.setInt(4, lid);

			ps.executeUpdate();		
		
			response.sendRedirect("lhome");


		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	

		
	}

}
