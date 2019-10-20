package com.controller;

import java.io.IOException;
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
 * Servlet implementation class RejectTask
 */
@WebServlet("/RejectTask")
public class RejectTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int tid=Integer.parseInt(request.getParameter("reject"));
	HttpSession session=request.getSession();
	int level=(Integer)session.getAttribute("level");


	Connection con=DatabaseConnection.getConnection();
	try {
		PreparedStatement ps=con.prepareStatement("delete from tasks where tid=?");
		ps.setInt(1,tid);
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


