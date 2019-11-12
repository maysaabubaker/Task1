package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.DatabaseConnection;
import com.model.Task;

/**
 * Servlet implementation class ViewTask
 */
@WebServlet("/ViewTask")
public class ViewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int pid=Integer.parseInt(request.getParameter("pid"));
		int level=(int) session.getAttribute("level");
	PrintWriter out=response.getWriter();
				
		Connection con=DatabaseConnection.getConnection();
		ArrayList<Task> tasks=new ArrayList<Task>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from tasks where aid=?");
			ps.setInt(1,pid);
			ResultSet result=ps.executeQuery();
			while(result.next())
			{
			int tid=result.getInt(1);		
			String title=result.getString(2);
			String summary=result.getString(3);
			String status=result.getString(4);
			Task t=new Task(tid,title,summary,status);
	        tasks.add(t);
			}
            request.setAttribute("vtasks", tasks);
            
           


		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd;
		if(level==1) 
		  rd =request.getRequestDispatcher("mhome");
		else
	      rd =request.getRequestDispatcher("lhome");

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
