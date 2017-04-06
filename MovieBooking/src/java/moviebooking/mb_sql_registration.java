/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tcs
 */
@WebServlet(name = "mb_sql_registration", urlPatterns = {"/mb_sql_registration"})
public class mb_sql_registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
    Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.138.77.215:30123/movie",
                    "root", "tcs"); //connect to database with username and password
    out.println(con);
            
            
        if (con == null)
    {
        out.println("Connection Not established Try again!!");
        RequestDispatcher rd=request.getRequestDispatcher("mb_database_no_connection.jsp");
    }
    Statement st = con.createStatement();
        
    boolean login_found=false;//variable to check the code enters the succuss loop
    
            String qry="INSERT INTO users (firstname, lastname, email, mobileno, dob, password, admin) VALUES (Santhosh,Nimmani,test@test.com,9963646301,21/06/1994,Tcs@12345,"+0+")";
            out.println(""+st+con+qry);
            java.sql.PreparedStatement ps=con.prepareStatement(qry);

            ResultSet rs;
            rs= ps.executeQuery();
String email="admin@tcs.com";
String pwd="admin";
          while (rs.next()) {
        if(email.equals(rs.getString("email")) && pwd.equals(rs.getString("password"))){
           if (con != null) {
              con.close();
            } 
            RequestDispatcher rd=request.getRequestDispatcher("mb_JsonParse");//forward it to the home page after succussful validation  
            rd.forward(request, response); //forward the request and response to the home page 
            login_found=true;//if code comes into this loop this variable will be true    
          
        }   
    
            out.println("Please check Data base Connection");
      //      RequestDispatcher rd=request.getRequestDispatcher("mb_database_no_connection.jsp");

   
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mb_sql_registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mb_sql_registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mb_sql_registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mb_sql_registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
