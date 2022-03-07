package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Book;


@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter out = null;
	
         public BookController() {
        super();
      
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateIds = request.getParameter("updateId");
		 out = response.getWriter();
		 System.out.println("Entering in post");
		 out.print("HI");
		int updateId;
		if(updateIds==null) {	
		
		String subject = request.getParameter("subject");
		String title = request.getParameter("title");		
	
		String author = request.getParameter("author");
		String priceS = request.getParameter("price");
		String publication = request.getParameter("publication");
		float price = Float.parseFloat(priceS);	
		String edition = request.getParameter("edition");
		
		
		//Date date = Date.parse(dateS);
		
	Book book =  new Book(1001L,subject,title,author,publication,edition,price);
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();	
		
		Transaction tx = session.beginTransaction();
		
		session.save(book);

		tx.commit();
		System.out.println("\n data saved successfully");
		
		response.sendRedirect("adminPage.jsp?books=book");
		
	}else {
		
		updateId = Integer.parseInt(updateIds);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");		
	
		String department = request.getParameter("department");
		String salaryText = request.getParameter("salary");
		String address = request.getParameter("address");
		float salary = Float.parseFloat(salaryText);	
		
		System.out.println("Id to be updated is: " + updateId);
		System.out.println(lastName);
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cyberinforminies_ems","root","basha");
		       // Statement st=conn.createStatement();
		        String query = "update employee set address=?,basicSalary=?,department=?,empFname=?,empLastName=? where empId=?";
		        PreparedStatement pstmt = conn.prepareStatement(query);
		        pstmt.setString(1,address);
		        pstmt.setFloat(2, salary);
		        pstmt.setString(3, department);
		        pstmt.setString(4, firstName);
		        pstmt.setString(5, lastName);
		        pstmt.setInt(6, updateId);        
		        
//		        PreparedStatement stmt=conn.prepareStatement("update emp set name=? where id=?");  
//		        pstmt.setString(1,"Sonoo");//1 specifies the first parameter in the query i.e. name  
//		        stmt.setInt(2,101);  
		          
		        int i=pstmt.executeUpdate();  
		        System.out.println(i+" records updated");  		       
		     
		       
		        System.out.println("updated successfully");
		        response.sendRedirect("employeeList.jsp");
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
			
	}
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
