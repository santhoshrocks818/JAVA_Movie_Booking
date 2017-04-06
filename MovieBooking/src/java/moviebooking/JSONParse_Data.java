package moviebooking;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tcs
 */
@WebServlet(urlPatterns = {"/JSONParse_Data"})
public class JSONParse_Data extends HttpServlet {

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
        try {
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
           // System.out.println(moviesObj);
    //    PrintWriter out = response.getWriter();
            try {
            /* TODO output your page here. You may use following sample code. */
             Object[]oa = null;
                oa= (Object[]) moviesObj.toArray();
                //JSONObject oa1= new JSONObject oa[1];
               // String some = oa1.getString("genre");
                        //a.getClass().getName()
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
                 System.out.println(jsonObject1.get("genre"));
                 i++;
                JSONObject obj = (JSONObject)o;
                request.getSession().setAttribute("jsondata",oa[1]);
    request.getRequestDispatcher("JSONArrayJsp.jsp").forward(request, response);
            
    String name = (String) obj.get("name");
                List<Array> list = new ArrayList<Array>();    
               
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
            
            /* TODO output your page here. You may use following sample code. */
        } finally {
            out.close();
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
       
               response.sendRedirect("JSONArrayJsp.jsp");

        
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
