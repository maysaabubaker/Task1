package com.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class TaskRecord {
private  ArrayList<Map> tasks=new ArrayList<Map>();
public  ArrayList getTasks(ResultSet result) {
	try {
		while(result.next())
		{
		Map userTask=new HashMap();
		int tid=result.getInt(1);
		userTask.put("tid",tid);
		
		String title=result.getString(2);
		userTask.put("title",title);

		String summary=result.getString(3);
		userTask.put("summary",summary);
		String status=result.getString(4);
		if(status!=null) {
		userTask.put("status",status);}
		else
			userTask.put("status","");
		
		tasks.add(userTask);
	
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return tasks;
	
}	
}
