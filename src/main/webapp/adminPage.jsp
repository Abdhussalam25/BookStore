<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
        <%@ page import= "java.io.*" %>
    <%
   // import javax.servlet.http.HttpSession;
  //  HttpSession session = request.getSession(false); // To avoid new session creation to continue with the same session.
	
 // if((String) session.getAttribute("userName") == "Admin"){
    
    %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Chandel Book Stores || ADMIN</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>

<style>
    ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color:#aebde1;
    }
    
 
    
    li:last-child {
      border-right: none;
    }
    
    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;

    }
    
    li a:hover:not(.active) {
      background-color: #111;
    }
    #background{
        background-image: url('salambasha.png');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
    position: fixed;
    width: 100%;
    max-width: 400px !important;
    
        margin-left: 700px;
    margin-top: 200px;
    
    word-break: break-word;

    }
  
    </style>
    </head>
    <body>
    

       <ul>
     
      <li style="float:right"><a href="index.jsp"><button class="btn btn-danger">Logout</button></a></li>
      <li style="float:right"><a href="changePassword.jsp"><button class="btn btn-warning">Change Password</button></a></li>
     
     </ul>
     <br><br>

     
   
    <!-- <h1>Assallaamu alaikkum</h1> -->

<div class="container"><a href="addBook.jsp">
     <button class="btn btn-success"> Add Book</button></a>
     </div>
     
     
    <table class="table table-bordered">
      <thead class="thead">
     <tr >
    
     <th> S.No </th>
     <th> Book Id </th>
     <th> Subject </th>
     <th> Title </th>
     <th> Author </th>
     <th> Publication </th>
     <th> Edition	 </th>
     <th> Price </th>
     <th> Actions</th>
     </tr>
   </thead>
   <tbody> 
   
   
    
         <%

     

     try {
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cyberinfomines_bookstore","root","basha");
       Statement st=conn.createStatement();
       
       ResultSet rs=st.executeQuery("select * from book"); 
       int i=0;
       PrintWriter out1 = response.getWriter();
       
       while(rs.next() ){  i++; 
       
       %>
         
           
             <tr>
             
       <td> <% out.print(i); %></td>
                  <td><%=  rs.getInt("bookId")%></td>
                   <td><%=  rs.getString("subject")%></td>
                   <td><%=  rs.getString("title")%></td>
                    <td><%=  rs.getString("author")%></td>
                     <td><%=  rs.getString("publication")%></td>
                      <td><%=  rs.getString("edition")%></td>
                       <td><%=  rs.getString("price")%></td>
                       <td>
                       <a href="BookController?bookId=<%=rs.getInt("bookId")%>"><i class="bi bi-eye-fill" style="padding:5px;"></i></a>
                       <a href="BookController?searchModId=<%=rs.getInt("bookId")%>"><i class="bi bi-pencil-square" style="padding:5px;"></i></a>
                       <a href="BookController?deleteId=<%=rs.getInt("bookId")%>"><button onclick="confirm('Are you sure to delete?');"><i class="bi bi-trash-fill" style="padding:5px;"></i></button></a>
                       
                       </td>
                   
              </tr>
             
         
       <% } 
       
           
         
       
   
       
       
 }catch(Exception e){
     e.printStackTrace();
    
     
 
} %>
     
     
     
     




   </tbody>

    </table>

  
    </body>
    </html>
 