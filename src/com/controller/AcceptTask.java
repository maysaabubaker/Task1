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
 * Servlet implementation class AcceptTask
 */
@WebServlet("/AcceptTask")
public class AcceptTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int tid=Integer.parseInt(request.getParameter("accept"));
	HttpSession session=request.getSession();
	int pid=(Integer)session.getAttribute("pid");
	int level=(Integer)session.getAttribute("level");

	Connection con=DatabaseConnection.getConnection();
	try {
		PreparedStatement ps=con.prepareStatement("update tasks set status=\"to do\" , lid=? where tid=?");
		ps.setInt(1,pid);
		ps.setInt(2,tid);
		ps.executeUpdate();
	}
	 catch (Exception e) {
			e.printStackTrace();
		}
		
	 if(level==1)
		 response.sendRedirect("mhome");
	 else
		 response.sendRedirect("lhome");
	}

}
