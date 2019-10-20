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

import com.model.DatabaseConnection;

public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		int level= Integer.parseInt(request.getParameter("level"));
		Connection con= DatabaseConnection.getConnection();
		try 
		{
			PreparedStatement ps =con.prepareStatement("insert into person"
			+ "(username,password,fname,lname,address,email,phonenumber,level)"
			+ "values(?,?,?,?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, address);
			ps.setString(6, email);
			ps.setString(7, phone);
			ps.setInt(8, level);
			ps.executeUpdate();
			
		}
		catch(Exception ex)
		{
		ex.printStackTrace();	
		}
		 response.sendRedirect("mhome");


	}

}
