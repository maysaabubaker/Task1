package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.DatabaseConnection;

/**
 * Servlet implementation class addTask
 */
@WebServlet("/addTask")
public class addTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int pid=(Integer)session.getAttribute("pid");
		String title=request.getParameter("title");
		String summary=request.getParameter("summary");
		Connection con=DatabaseConnection.getConnection();
		int level=(Integer)session.getAttribute("level");

		try {
			PreparedStatement ps;
			if(level==1)
			ps=con.prepareStatement("insert into tasks(title,summary,aid,status) values(?,?,?,'in progress')");
			else if(level==2)
			ps=con.prepareStatement("insert into tasks(title,summary,aid,status) values(?,?,?,'waiting manager')");
			else
			ps=con.prepareStatement("insert into tasks(title,summary,aid,status) values(?,?,?,'waiting leader')");
	
			ps.setString(1,title);
			ps.setString(2, summary);
			
			ps.setInt(3, pid);

			ps.executeUpdate();
			if(level==1)
				 response.sendRedirect("mhome");
			else if(level==2)
				 response.sendRedirect("lhome");
			else
				 response.sendRedirect("dhome");


		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
