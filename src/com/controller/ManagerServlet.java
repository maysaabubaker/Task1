package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import com.model.*;


/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
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
		ArrayList<Task> tasks=new ArrayList<Task>();
		ArrayList<Person> developers=new ArrayList<Person>();
		ArrayList<Person> leaders=new ArrayList<Person>();


		try {
			PreparedStatement ps=con.prepareStatement("select * from tasks where aid=?");
			ps.setInt(1,pid);
			ResultSet result1=ps.executeQuery();
			while(result1.next())
			{
			int tid=result1.getInt(1);		
			String title=result1.getString(2);
			String summary=result1.getString(3);
			String status=result1.getString(4);
			Task t=new Task(tid,title,summary,status);
	        tasks.add(t);
			}
           request.setAttribute("userTasks", tasks);
			
		    Statement stm=con.createStatement();
			ResultSet result=stm.executeQuery("select fname,lname,level,id,lid"
			+ " from person where level=2 or level=3");
			while(result.next())
			{String name=result.getString(1)+" "+result.getString(2);
			int id=Integer.parseInt(result.getString(4));
			int level=result.getInt(3);
			int lid=result.getInt(5);

			PreparedStatement ps2=con.prepareStatement("select fname,lname from person where id=?");
			ps2.setInt(1,lid);
			ResultSet result2=ps2.executeQuery();
			String lname = "";
			if (result2.next()) {
			lname=result2.getString(1)+" "+result2.getString(2);
			}
			Person p=new Person(id,name,level,lname);


			if(level==2) {
			leaders.add(p);	
			}
			else {
			developers.add(p);	
			}
			}
            request.setAttribute("leaders", leaders);
            request.setAttribute("developers", developers);
			  

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 RequestDispatcher rd =request.getRequestDispatcher("/ManagerHome.jsp");
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
