package com.cng.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.image.impl.ByteIndexed.Getter;



/**
 * Servlet implementation class PumpLogin
 */
public class PumpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PumpLogin() {
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
		String mo=request.getParameter("mobile");
		String password=request.getParameter("password");
		
	  try
		{
			  Connection con=ConnectionCall.getConnect();
			  PreparedStatement ps=con.prepareStatement("select * from preg where pmobile=? and ppass=? and pstatus=?");
			  ps.setString(1,mo);
			   ps.setString(2,password);
			   ps.setString(3,"Approved");
			   ResultSet rs1=ps.executeQuery();
				  if(rs1.next())
				  {
						GetterDemo.setMobile(rs1.getString(8));
						GetterDemo.setPname(rs1.getString(1));
						GetterDemo.setCity(rs1.getString(3));
						// GetterDemo.setPid(rs1.getInt(14));


					    response.sendRedirect("OCNGPump.html");
				  }
				  else
				  {
					  response.sendRedirect("PLogin.html");
				  }
				  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	}


