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
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.RequestDispatcher;
import moviebooking.beans.JsonObject_bean;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author tcs
 */

public class JsonParse {
     List<String> list = new ArrayList<String>();    
     public Object[] oa = null;
     
        public static void main(String[] args) {
      //  List<String> list = new ArrayList<String>();        //response.setContentType("text/html;charset=UTF-8");
        JsonObject_bean jsonobject_bean;

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
                   
                //System.out.println(oa[i]);
                JSONParser parser1 = new JSONParser();  

                  JSONObject jsonObject1;
                  jsonObject1 = new JSONObject();
                 try {
                    jsonObject1 =  (JSONObject) parser1.parse(oa[i].toString());
                 } catch (org.json.simple.parser.ParseException ex) {
                //Logger.getLogger(JavaParse.class.getName()).log(Level.SEVERE, null, ex);
                }
                 //System.out.println(jsonObject1.get("language"));
                 i++;
                JSONObject obj = (JSONObject)o;
                //SSystem.out.println(obj);

                JsonObject_bean xjsonobject_bean = new JsonObject_bean();
                xjsonobject_bean = mb_JsonParse.jsonobject_bean;
//jsonobject_bean.setJsonobject(jsonObject1);
                
               // String name = (String) obj.get("name");
               // List<Array> list = new ArrayList<Array>();    
               
                //JSONArray moviesObj1=(JSONArray)jsonObject1.get("genre");
                //list.add((Array) moviesObj1);
//list.add((String) obj.get("name"));
         //     request.setAttribute("list",list );

               // out.println("Genre:"+obj.get("genre"));
              //  out.println("<br>");
               System.out.println(mb_JsonParse.jsonobject_bean.getJsonobject());

               }
           
        } finally {
          //  out.close();
        } }catch (MalformedURLException e) {
    }catch (IOException e) {
    }

       //RequestDispatcher rd = request.getRequestDispatcher("/mb_home.jsp");
      // rd.forward(request, response);
    
}
}