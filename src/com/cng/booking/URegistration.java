package com.cng.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URegistration
 */
public class URegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URegistration() {
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mo=request.getParameter("mobile");
		String pass=request.getParameter("password");
		String city=request.getParameter("city");
		
		

		
		try
		{

			   Connection con=ConnectionCall.getConnect();
			   PreparedStatement ps=con.prepareStatement("insert into ureg values(?,?,?,?,?,?)");
			   ps.setInt(1,0);
			   ps.setString(2,name);
			   ps.setString(3,email);
			   ps.setString(4,mo);
			   ps.setString(5,pass);
			   ps.setString(6,city);
			   
			 
			   
			   int i=ps.executeUpdate();
			   if(i>0)
			   {
				 // GetterDemo.setName(name);
				   
			     //  GetterDemo.setEmail(email);
			       //GetterDemo.setCity(city);
				    response.sendRedirect("Success.html");
			   }
			   else
			   {
				   response.sendRedirect("UnSuccess.html");
			   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
		
	}


