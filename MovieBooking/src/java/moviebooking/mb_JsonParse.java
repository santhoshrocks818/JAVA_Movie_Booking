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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moviebooking.beans.JsonObject_bean;
import moviebooking.beans.User_bean;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tcs
 */
@WebServlet(name = "mb_JsonParse", urlPatterns = {"/mb_JsonParse"})
public class mb_JsonParse extends HttpServlet {
     /**
     *
     */
    public static JsonObject_bean jsonobject_bean;
    public static User_bean user_bean;
    public static String admin;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        admin = request.getParameter("admin");
        URL url;
        try {
        url = new URL(" http://10.138.77.63:30116/getmovielist");
        HttpURLConnection conn;
        conn = (HttpURLConnection) url.openConnection();
        System.out.println(conn);
        conn.setRequestMethod("GET");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        String jString=new String();
	out.println("Output from Server .... \n");
	while ((output = br.readLine()) != null) {
		jString += output;              
            }
            JSONParser parser = new JSONParser();              
            JSONObject jsonObject;
            jsonObject = new JSONObject();
            try {
                jsonObject =  (JSONObject) parser.parse(jString);
            } catch (org.json.simple.parser.ParseException ex) {
                  }
            JSONArray moviesObj=(JSONArray)jsonObject.get("movies");
            //try{
            user_bean = new User_bean();
            user_bean.setAdmin(request.getParameter("admin"));
           jsonobject_bean = new JsonObject_bean();
           jsonobject_bean.setMoviesObj(moviesObj);
    //    PrintWriter out = response.getWriter();
            try {
            /* TODO output your page here. You may use following sample code. */
             Object[]oa = null;
             oa= (Object[]) moviesObj.toArray();
             out.println(oa.getClass().getName());
             int i=0;
             for(Object o:oa){
                i++;
                JSONParser parser1 = new JSONParser();  
                JSONObject jsonObject1;
                jsonObject1 = new JSONObject();
                 try {
                    jsonObject1 =  (JSONObject) parser1.parse(oa[i].toString());
                 } catch (org.json.simple.parser.ParseException ex) {
                }
                JSONObject obj = (JSONObject)o;
                jsonobject_bean.setJsonobject(jsonObject1);
                
                RequestDispatcher requestDispatcher; 
                requestDispatcher = request.getRequestDispatcher("/mb_Home_JSONParse.jsp");
                requestDispatcher.forward(request, response);
             }
           
        } finally {
           out.close();
        } }catch (MalformedURLException e) {
            out.println("The JSON data is not parsed please check your connection");
    }catch (IOException e) {
    }catch (Exception e){
    out.println("The JSON data is not parsed please check your connection");

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
        processRequest(request, response);
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
        processRequest(request, response);
     
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
