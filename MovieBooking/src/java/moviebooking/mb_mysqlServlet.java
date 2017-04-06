/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moviebooking.beans.JsonObject_bean;
import moviebooking.beans.User_bean;
import org.apache.catalina.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @    Author     : tcs@975087:Santhosh Nimmani

 */
public class mb_mysqlServlet extends HttpServlet {
    JsonParse jsonParse = new JsonParse();
    public static String admin = null;
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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    //Validate the email and password fetching from data base
    String email = request.getParameter("email");//get email from jsp   
    String pwd = request.getParameter("pass");//get password from jsp
    List<String> newList = jsonParse.list;
    Connection con= null;
    ResultSet rs;
    User_bean user = null;

    try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://10.138.77.215:30123/movie",
            "root", "tcs");//connect to database with username and password
    if (con == null)
    {
        out.println("Connection Not established Try again!!");
        RequestDispatcher rd=request.getRequestDispatcher("mb_database_no_connection.jsp");
    }
    Statement st = con.createStatement();
        
    boolean login_found=false;//variable to check the code enters the succuss loop
    rs = st.executeQuery("select * from users");
    while (rs.next()) {
        if(email.equals(rs.getString("email")) && pwd.equals(rs.getString("password"))){
           if (con != null) {
              con.close();
            }

              RequestDispatcher rd=request.getRequestDispatcher("mb_JsonParse");//forward it to the home page after succussful validation  
              rd.forward(request, response); //forward the request and response to the home page 
              login_found=true;//if code comes into this loop this variable will be true    
          
           
        }      
    }
    if(login_found!=true){//if the variable is not true than the condition is false so pease enter correct credientials
            out = response.getWriter();
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Please Enter Valid Email/Password');");  
            out.println("location='mb_login.jsp';");
            out.println("</script>");
        }
        
    } 
      
     catch (Exception e){
            //out.println("Please check Data base Connection");
            RequestDispatcher rd=request.getRequestDispatcher("mb_database_no_connection.jsp");

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
        } catch (SQLException ex) {
            Logger.getLogger(mb_mysqlServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mb_mysqlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            JsonObject_bean jsonobject_bean = null;

        URL url;
        try {
        //url = new URL(" http://10.138.77.211:50001/getmoviebyname?name=Kung Fu Yoga&language=English");
        //url = new URL("http://10.138.77.211:50003/getmoviebyname?movie_name=Kung%20Fu%20Yoga&language=English");
        url = new URL(" http://10.138.77.211:50003/getmovielist");
        HttpURLConnection conn;
        conn = (HttpURLConnection) url.openConnection();
        System.out.println(conn);
        //conn.setDoOutput(true);
        //conn.setDoInput(true);
        conn.setRequestMethod("GET");
        //conn.setRequestProperty("Accept", "application/json");
        //conn.setRequestProperty("Content-Type","application/json");
        
        BufferedReader br;
            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        String jString=new String();
	System.out.println("Output from Server .... \n");
	while ((output = br.readLine()) != null) {
		jString += output;              
            }
            JSONParser parser = new JSONParser();              
            JSONObject jsonObject;
            jsonObject = new JSONObject();
            try {
                jsonObject =  (JSONObject) parser.parse(jString);
            } catch (org.json.simple.parser.ParseException ex) {
                //Logger.getLogger(JavaParse.class.getName()).log(Level.SEVERE, null, ex);
            }
            JSONArray moviesObj=(JSONArray)jsonObject.get("movies");
            //try{
          
    //    PrintWriter out = response.getWriter();
            try {
            /* TODO output your page here. You may use following sample code. */
             Object[]oa = null;
                oa= (Object[]) moviesObj.toArray();
                 System.out.println(oa.getClass().getName());
                //JSONObject oa1= new JSONObject oa[1];
               // String some = oa1.getString("genre");
                        
               // oa1 = oa[1].toString();
               int i=0;
               for(Object o:oa){
                   
                System.out.println(oa[i]);
                JSONParser parser1 = new JSONParser();  

                  JSONObject jsonObject1;
                  jsonObject1 = new JSONObject();
                 try {
                    jsonObject1 =  (JSONObject) parser1.parse(oa[i].toString());
                 } catch (org.json.simple.parser.ParseException ex) {
                //Logger.getLogger(JavaParse.class.getName()).log(Level.SEVERE, null, ex);
                }
                 System.out.println(jsonObject1.get("language"));
                 i++;
                JSONObject obj = (JSONObject)o;
                jsonobject_bean.setJsonobject(obj);
               // String name = (String) obj.get("name");
               // List<Array> list = new ArrayList<Array>();    
               
                //JSONArray moviesObj1=(JSONArray)jsonObject1.get("genre");
                //list.add((Array) moviesObj1);
//list.add((String) obj.get("name"));
         //     request.setAttribute("list",list );
               //System.out.println(jsonObject1);

               // out.println("Genre:"+obj.get("genre"));
              //  out.println("<br>");
               //System.out.println("Genre:"+obj.get("genre"));
            }
           
        } finally {
          //  out.close();
        } }catch (MalformedURLException e) {
    }catch (IOException e) {
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
        } catch (SQLException ex) {
            Logger.getLogger(mb_mysqlServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mb_mysqlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the 
     * .
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

 //  private void readjsondata() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
    }


