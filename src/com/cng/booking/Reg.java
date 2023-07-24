package com.cng.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Reg
 */
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
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
		String pn=request.getParameter("pumpname");
		String ad=request.getParameter("address");
		String ci=request.getParameter("city");
		String tal=request.getParameter("taluka");
		String dis=request.getParameter("district");
		String otime=request.getParameter("opentime");
		String ctime=request.getParameter("closetime");
		String mo=request.getParameter("mobile");
		float lat=Float.parseFloat(request.getParameter("latitude" ));
		float lon=Float.parseFloat(request.getParameter("longitude"));
		String pass=request.getParameter("password");
		String cn=request.getParameter("cng");
	
		

		
		try
		{

			   Connection con=ConnectionCall.getConnect();
			   PreparedStatement ps=con.prepareStatement("insert into preg values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			   ps.setString(1,pn);
			   ps.setString(2,ad);
			   ps.setString(3,ci);
			   ps.setString(4,tal);
			   ps.setString(5,dis);
			   ps.setString(6,otime);
			   ps.setString(7,ctime);
			   ps.setString(8,mo);
			   ps.setFloat(9,lat);
			   ps.setFloat(10,lon);
			   ps.setString(11,pass);
			   ps.setString(12,cn);
			   ps.setString(13,"pending");
			   
			   int i=ps.executeUpdate();
			   if(i>0)
			   {
				    response.sendRedirect("PLogin.html");
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


