package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.*;
import java.sql.*;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		doPost(request,response);	
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("pass");
		Connection con=DatabaseConnection.getConnection();
		PrintWriter out =response.getWriter();

		try {
			PreparedStatement ps=con.prepareStatement("select count(*),level,id from person where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet result=ps.executeQuery();
			int count=0;int level=0;int pid=0;
			while(result.next())
			{
				count=result.getInt(1);
				level=result.getInt(2);
				pid=result.getInt(3);
			

			}
			

			if(count==1)
			{
				 HttpSession session=request.getSession(true);
					session.setAttribute("username", username);
					session.setAttribute("level", level);
					session.setAttribute("pid", pid);
			if(level==1){

			   response.sendRedirect("mhome");
			 }
			else if(level==2) {

			    response.sendRedirect("lhome");
			}
			else
			{
			    response.sendRedirect("dhome");
	
			}
			
			}
			else
			{
				 
				out.println("wrong username or password");

			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
