package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.DatabaseConnection;
import com.model.TaskRecord;

/**
 * Servlet implementation class LeaderServlet
 */
@WebServlet("/LeaderServlet")
public class LeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int pid=(Integer)session.getAttribute("pid");
	PrintWriter out=response.getWriter();
				
		Connection con=DatabaseConnection.getConnection();
		ArrayList<HashMap<String,String>> developers=new ArrayList<HashMap<String,String>>();

		try {
			ArrayList tasks=new ArrayList();
			PreparedStatement ps=con.prepareStatement("select * from tasks where aid=?");
			ps.setInt(1,pid);
			ResultSet result1=ps.executeQuery();
			TaskRecord tr=new TaskRecord();
		   tasks=tr.getTasks(result1);
           request.setAttribute("userTasks", tasks);
			
            PreparedStatement ps2=con.prepareStatement("select fname,lname,level,id,lid"
			+ " from person where lid=?");
       	    ps2.setInt(1,pid);
		    ResultSet result2=ps2.executeQuery();
			while(result2.next())
			{
				HashMap<String,String> map=new HashMap<String,String>();	
			
			map.put("name", result2.getString(1)+" "+result2.getString(2));
			
			map.put("id", result2.getString(4));	

			developers.add(map);	
			
			}
            request.setAttribute("developers", developers);

            
			  

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 RequestDispatcher rd =request.getRequestDispatcher("/LeaderHome.jsp");
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
