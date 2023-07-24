package com.cng.booking;

import java.io.IOException; 
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.*;
//import com.mysql.jdbc.Connection;



/**
 * Servlet implementation class BookCity
 */
public class BookCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCity() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	
		
		
		int cngh=Integer.parseInt(request.getParameter("cngh"));
		 String pcity=GetterDemo.getCity();
		 String pname=GetterDemo.getPname();
		String ct=GetterDemo.getUcity();
		String uname= GetterDemo.getName();
		String em=GetterDemo.getEmail();
		String pmobile=GetterDemo.getMobile();
    
		
		int pid=0;

		  try
			{
			  int avail=0;
			  Connection con=ConnectionCall.getConnect();				  
				  
				 
				  
				  //???????????????0???????????????????/
				  PreparedStatement ps1=con.prepareStatement("select * from preg where pmobile=?");
				  ps1.setString(1, pmobile);
			     ResultSet rs=ps1.executeQuery();
			
					  while(rs.next())
					  {
						  pcity=rs.getString(3);
						 avail=rs.getInt(12);
						 pname=rs.getString(1);
						 pid=rs.getInt(14);
						 
					  }
		
					 if(cngh<avail)
					 {
						 PreparedStatement ps = con.prepareStatement("insert into booking values(?,?,?,?,?,?,?)");
						  
						   ps.setInt(1,0);
						   ps.setString(2,uname);
						   ps.setString(3,em);
						   ps.setString(4,ct);
						   ps.setString(5,pname);
						   ps.setString(6,pcity);
						   ps.setInt(7,cngh);
						    ps.executeUpdate();
						   
						   
						    int newbal=avail-cngh;
						    
						   PreparedStatement ps3=con.prepareStatement("update preg set pcng=? where pmobile=?" );
						   ps3.setInt(1,newbal);
						   ps3.setString(2,pmobile);
						   int i=ps3.executeUpdate();
						   if(i>0)
						   {
							    response.sendRedirect("Success.html");
						   }
						   else
						   {
							   response.sendRedirect("UnSuccess.html");
						   }
					 }
					  
			}
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
