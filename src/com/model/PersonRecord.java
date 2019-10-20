package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PersonRecord {
private HashMap<String, String> person=new HashMap<String, String>();
private String fname,lname,address,email,phonenumber,job,level;
public HashMap<String, String> getPerson(ResultSet result)
{
	try {
		while(result.next())
		{
		 fname=result.getString(1);
		person.put("fname",fname);
		
		 lname=result.getString(2);
		person.put("lname",lname);
		
		 address=result.getString(3);
		person.put("address",address);

		 email=result.getString(4);
		person.put("email",email);
		
		 phonenumber=result.getString(5);
		person.put("phonenumber",phonenumber);
		
		 level=result.getString(6);
		person.put("level",level);
	
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return person;
}
}
