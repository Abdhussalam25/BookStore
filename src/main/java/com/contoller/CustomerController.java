package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Customer;


@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CustomerController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession(false);
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		String email = request.getParameter("email");
		
		String phoneNumber = request.getParameter("phoneNumber");
		String age = request.getParameter("age");
		
		String gender = request.getParameter("gender");
		
		String address = request.getParameter("address");
		
		Customer customer = new Customer(firstName,lastName,email,phoneNumber,age,gender,address);
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();	
		
		Transaction tx = session.beginTransaction();
		
		session.save(customer);

		tx.commit();
		System.out.println("\n data saved successfully");
		
		httpSession.setAttribute("firstName", firstName);
		response.sendRedirect("custLogin.jsp? ");
		
		
		
	
	}

}
