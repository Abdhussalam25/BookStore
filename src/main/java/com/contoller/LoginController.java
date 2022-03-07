package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			session.setAttribute("userName", userName);
			String currentUserName = request.getParameter("currentUserName");
			String currentPassword = request.getParameter("currentPassword");
			String newPassword1 = request.getParameter("newPassword1");
			
			if(currentUserName != null && currentPassword != null && newPassword1 != null) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");			
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cyberinfomines_bookstore","root","basha");
					Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery("select * from `admin_table` where `userName`='"+currentUserName+"' and `password`='"+currentPassword+"'");
						
					if(rs.next())
					{
						String query = "update `admin_table` set `password`=? where `userName`=?  and `password`=?";
				        PreparedStatement pstmt = conn.prepareStatement(query);
				        pstmt.setString(1,newPassword1);
				        pstmt.setString(2, currentUserName);
				        pstmt.setString(3, currentPassword);
				        
				        int i=pstmt.executeUpdate();  
				        System.out.println(i+" records updated");  	   
				       
				        System.out.println("updated successfully");
						response.sendRedirect("login.jsp");
						
						
					}
					else
					{
						response.sendRedirect("login.jsp?credencials=invalid");
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
			
				
				
			}else {
				out.print("<h4 style='color:red'> All the fields are required </h4>");
			}
			
			
			
			
			
			
			
			
			
			if(userName != null && password != null) {
			
			try {
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");			
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cyberinfomines_bookstore","root","basha");
					Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery("select * from `admin_table` where `user_name`='"+userName+"' and `password`='"+password+"'");
					
					
					if(rs.next())
					{
						
						response.sendRedirect("adminPage.jsp");
						session.setAttribute("user",userName);
						
						
					}
					else
					{
						response.sendRedirect("login.jsp?credencials=invalid");
					}
					
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			}else {
				
				out.print("<h4 style='color:red'> Either Username or Password is null  </h4>");
				
			}
			
			
		}

		
	}


