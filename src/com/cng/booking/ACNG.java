package com.cng.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ACNG
 */
public class ACNG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ACNG() {
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
		 int cn=Integer.parseInt(request.getParameter("CNG"));
		 int total=0;
		 String mo=GetterDemo.getMobile();
		 
		 try
		 {
		 Connection con=ConnectionCall.getConnect();
		  PreparedStatement ps=con.prepareStatement("select * from preg where pmobile=?");
		 
		   ps.setString(1,mo);
		   ResultSet rs=ps.executeQuery();
			  if(rs.next())
			  {
				  
				  int amount=rs.getInt(12);
				  total=amount+cn;
				  
			  }
			  PreparedStatement ps1=con.prepareStatement("update preg set pcng=? where pmobile=?");
			  ps1.setInt(1,total);
			  ps1.setString(2,mo);
			  int i=ps1.executeUpdate();
			  if(i>0)
			  {
				  response.sendRedirect("UpdateData.jsp");
			  }
			  else
			  {
				  response.sendRedirect("UpdateData.jsp");
			  }
			  
			  
			 
		 }
		 
		 catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		
		
	}

}
