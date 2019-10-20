package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.DatabaseConnection;

public class changeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status=request.getParameter("cstat");
	HttpSession session=request.getSession();
	int pid=(Integer)session.getAttribute("pid");
	int tid=Integer.parseInt(request.getParameter("tid"));
	int level=(Integer)session.getAttribute("level");
	
	Connection con=DatabaseConnection.getConnection();
	try {
		
		PreparedStatement ps=con.prepareStatement("update tasks set status=? where aid=? and tid=?");
		ps.setString(1,status);
		ps.setInt(2,pid);
		ps.setInt(3,tid);
		ps.executeUpdate();
	}
	 catch (Exception e) {
			e.printStackTrace();
		}
	if(level==1)
	    response.sendRedirect("mhome");
	else if(level==2)
		response.sendRedirect("lhome");
	else
		response.sendRedirect("dhome");
		
	}

}
