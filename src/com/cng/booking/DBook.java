package com.cng.booking;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Book
 */
public class DBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBook() {
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
		
		int cngh=Integer.parseInt(request.getParameter("cng"));
		//String unm=GetterDemo.getName();
		
		String ct=null,un=null;
		String em=GetterDemo.getEmail();
	//	String ci=GetterDemo.getCity();
	
		String pnm=request.getParameter("pname");
		String pct=request.getParameter("pcity");
		

		  try
			{
			  int avail=0;
				  Connection con=ConnectionCall.getConnect();
				  
				  
				  PreparedStatement ps5=con.prepareStatement("select * from ureg where uemail=?");
				  ps5.setString(1,em);
				  ResultSet rs5=ps5.executeQuery();
				  while(rs5.next())
				  {
					  
					 ct=rs5.getString("ucity");
				     un=rs5.getString("uname");
					  
				  }
				  
				  //???????????????0???????????????????/
				  PreparedStatement ps1=con.prepareStatement("select * from preg where pname=?");
				  ps1.setString(1,pnm);
				 
				   ResultSet rs=ps1.executeQuery();
					  while(rs.next())
					  {
						 avail=rs.getInt(12);
					  }
					 if(cngh<avail)
					 {
						  PreparedStatement ps=con.prepareStatement("insert into booking values(?,?,?,?,?,?,?)");
						   ps.setInt(1,0);
						   ps.setString(2,un);
						   ps.setString(3,em);
						   ps.setString(4,ct);
						   ps.setString(5,pnm);
						   ps.setString(6,pct);
						   ps.setInt(7,cngh);
						    
						   int i=ps.executeUpdate();
						   PreparedStatement ps3=con.prepareStatement("update preg set pcng=pcng-? where pname=?" );
						   ps3.setInt(1,cngh);
						   ps3.setString(2,pnm);
						   int j=ps3.executeUpdate();
						   if(i>0 && j>0)
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
