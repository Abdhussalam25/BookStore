<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
  
    <%@ include file = "header.jsp" %>



        <div id="content" style="margin-top:auto;margin-left: 150px;margin-right: 150px; height:50vh;">
  
              
                <div class="card">
             
                  <div class="card-body" style="margin-left: 250px; height:50vh">
               
                      <div class="col-lg-12  form-group">
                        
                          <div class="row">
                            <div id="reportrange" class="pull-center" style="cursor: pointer; width: 100%;">
                              <form class="" action="LoginController" method="post" style="margin-left: 100px;">
                              <div style="text-align: center; display: flex; margin-top: 5px; margin-bottom: 5px; font-size: 16px;">
                                <!-- <label for="userName" >  Enter UserName: </label> -->
                             <input type="text" placeholder="Enter Username" name="currentUserName" required style="margin-left: 20px; width:25vw; height: 25px;" required>

                              </div>
                              <div style="text-align: center; display: flex;  margin-top: 5px; margin-bottom: 5px;font-size: 16px;">
                                <!-- <label for="userName">    Current Password: </label> -->
                         <input type="password" placeholder="Enter Current Password" name="currentPassword" required style="margin-left: 20px; width:25vw; height: 25px;" required>
                              </div>
                              <div style="text-align: center;display: flex;  margin-top: 5px; margin-bottom: 5px;font-size: 16px;">
                                <!-- <label for="userName">    New Password: </label> -->
                             <input type="password" placeholder="Enter New Password" name="newPassword1" required style="margin-left: 20px; width:25vw; height: 25px;" required>
                              
                              </div>
                              <!-- <div style="text-align: center;display: flex;  margin-top: 5px; margin-bottom: 5px; font-size: 16px;">
                                 <label for="userName">  ReEnterPassword:</lab
                             <input type="password" placeholder="Re enter the new Password" name="newPassword2" required style="margin-left: 20px; width:25vw; height: 25px;" >
                            </div> -->
                            <div style="text-align: center;display: flex;  margin-top: 5px; margin-bottom: 5px;" >
                              <button type="submit" class="btn btn-success" style="margin-left: 20px; width:25vw; height: 25px;">Save</button>
                            </div>
                            </form>
                            </div>
                          </div>
                        
                       
                      </div>
                
                   </div>
                </div>
       
         
        </div>





  