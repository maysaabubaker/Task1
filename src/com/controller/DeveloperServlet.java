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

import com.model.*;

public class DeveloperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeveloperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		int level=(Integer)session.getAttribute("level");
		int pid=(Integer)session.getAttribute("pid");
	PrintWriter out=response.getWriter();
				
		Connection con=DatabaseConnection.getConnection();
		ArrayList tasks=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement("select * from tasks where aid=?");
			ps.setInt(1,pid);
			ResultSet result=ps.executeQuery();
			TaskRecord tr=new TaskRecord();
		tasks=tr.getTasks(result);
            request.setAttribute("userTasks", tasks);
            
           

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 RequestDispatcher rd =request.getRequestDispatcher("/DeveloperHome.jsp");
			rd.forward(request, response);	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			doGet(request,response);
		}
		}
	

}
