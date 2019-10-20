package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DatabaseConnection.getConnection();
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();
		int pid=(Integer)session.getAttribute("pid");
		out.println(pid);

		try {
			PreparedStatement ps=con.prepareStatement("select fname,lname,address"
			+ ",email,phonenumber,level_type from person,levels where id=?"
			+" and person.level=levels.level_num ");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			PersonRecord p=new PersonRecord();
			HashMap<String, String> person=p.getPerson(rs);
			request.setAttribute("person", person);
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
			
		 RequestDispatcher rd =request.getRequestDispatcher("/profile.jsp");
		rd.forward(request, response);		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
