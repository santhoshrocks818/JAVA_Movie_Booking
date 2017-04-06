<%-- 
    Document   : mb_registration_sql
    Created on : 28 Feb, 2017, 10:53:10 AM
    Author     : tcs
--%>

<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.*"%>

<%@ page 
  import = "java.io.*"
  import = "java.sql.*"
  import = "java.util.*"
  import = "javax.sql.*"
  import = "java.sql.ResultSet"
  import = "java.sql.Statement"
  import = "java.sql.Connection"
  import = "java.sql.DriverManager"
  import = "java.sql.SQLException"
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        
    </head>
    <body>
                
        <thead>
                    <tr>
                        <th class="whitetext" colspan="2"><h2>Record created in datanbase</h2></th>
                    </tr>
        </thead> 

    <%
        int result = 0;
	Connection con = null;
       
        ResultSet rs=null;
        request.getSession();
        
        String fn=request.getParameter("fname");
        String sn=request.getParameter("lname");
        String em=request.getParameter("email");
        String dob=request.getParameter("date");
        String mob=request.getParameter("phone");
        String pass=request.getParameter("password");
        String conf_pass=request.getParameter("conf_pass");
        out.print("==================== <br/> ");
        out.print("FirstName :  "+ fn +"<br/>");
        out.print("SecondName :  "+ sn +"<br/>");
        out.print("Email :  "+ em +"<br/>");
        out.print("DateOfBirth :  "+ dob +"<br/>");
        out.print("Mobile :  "+ mob +"<br/>");
        out.print("Password :  "+ pass +"<br/>");
        out.print("Confirmed Password :  "+ conf_pass +"<br/>");
        out.print("==================== <br/> ");
        try{
        Class.forName("com.mysql.jdbc.Driver");
       
        con = DriverManager.getConnection(
        "jdbc:mysql://10.138.77.215:30123/movie", "root", "tcs");
       // con = (Connection)DriverManager.getConnection("jdbc:mysql://10.138.77.63:33306/movie", "root", "tcs");
	Statement st = null;
        st= con.createStatement();
        
        out.print("Connection="+con+"<br/>");
        String qry="INSERT INTO users (firstname, lastname, email, mobileno, dob, password, admin) VALUES ("+fn+","+sn+","+em+","+mob+","+dob+","+pass+","+0+")";
       	//out.print("Record Inserted Successfully ---" + st + "=-------" + dob);
        out.print("Query===== "+qry +"<br/>");
        //result=st.executeUpdate("INSERT INTO users (firstname, lastname, email, mobileno, dob, password, admin) VALUES (fn,ln,em,mob,dob,pass,'0');");
        // out.print("Record Inserted Successfully ---" + st + result + "=-------" + fn);
        //
        String qry2="INSERT INTO users (firstname, lastname, email, mobileno, dob, password, admin) VALUES (?,?,?,?,?,?,?)";
         java.sql.PreparedStatement ps=con.prepareStatement(qry);
     
         ps.setString(1, fn);
         ps.setString(2, sn);
         ps.setString(3, em);
         ps.setString(4, dob);
         ps.setString(5, mob);
         ps.setString(6, pass);
         ps.setString(7,conf_pass);
            
            
         out.print("Prepare statement ----1 "+ps+"<br/>");   
          if(result==0){
        rs = ps.executeQuery();
        result=1;
          }
          
          out.print("Prepare statement----2"+ps+"<br/>");
          out.print("Record Inserted Successfully ---" + st + result + "=-------" + fn);
          if(result == 1)
	  {
		out.print("Record Inserted Successfully ---" + st);
	  }
          }
           catch(Exception e){
          System.out.print(e);
          e.printStackTrace();
           }
   

    %> 
    </body>

</html>
