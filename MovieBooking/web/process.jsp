<%-- 
    Document   : JSONArrayJsp
    Created on : 28 Feb, 2017, 1:41:41 PM
    Author     : tcs
--%>

<%@page import="moviebooking.beans.User_bean"%>
<%@page import="java.util.Iterator"%>
<%-- <%@page import="jdk.nashorn.internal.objects.NativeFunction.function(boolean, Object, Object[]);"%>
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="moviebooking.mb_JsonParse"%>
<%@page import="moviebooking.beans.JsonObject_bean"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.json.JSONException,org.json.simple.JSONArray"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home Page</title>
<script type="text/javascript">
function direct(name,job) {
     alert(name+job)
}
           

window.onbeforeunload = function() { return alert("You work will be lost."); };
 /*function data(x){
     out.println("BOOKID"+x);
 }*/
</script>


 <style> 
     .navbar {
    color: black;
    background-color:   #0089b1;
}

.nav.navbar-nav li a {
 color: black;
}
.navbar-header a{
        color: whitesmoke;

}
    .container{
        padding: 16px;
        margin-top: 50px;
        height: 1500px; /* Used in this example to enable scrolling */
        overflow:hidden;
     }
     .list-group-item{
         height: 180px;
         
     }
    footer{
        bottom:0;
        position: fixed;
    color: black;
        background-color: #0089b1;
        text-align: center;
        padding: 14px 16px;
        width: 100%;

    }
  
    </style>
</head>
<body>
    
  <nav class="navbar navbar-inverse navbar-fixed-top nav-pills nav-tabs">
  <div class="container-fluid">
        
    <ul class="nav navbar-nav">
          <a class="navbar-brand" href="#">Logo</a>
    </ul>
    <ul class="nav navbar-nav navbar-right">  
        <form class="navbar-form navbar-left">
         <div class="input-group">
             <input type="text" class="form-control" placeholder="Search by Movie">
             <div class="input-group-btn">
             <button class="btn btn-default" type="submit">
             <i class="glyphicon glyphicon-search"></i>
            </button>
         </div>
         </div>
        
        </form>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span><%out.println(request.getParameter("email"));%></a></li>
      <li class=""><a href="#">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Select
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Hyderabad</a></li>
          <li><a href="#">Vijayawada</a></li>
          <li><a href="#">Visakapatanam</a></li>
        </ul>
      </li>
        
      <li><a href="success.jsp">Sort</a></li>
      
      <li><a href="mb_logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
    
    
    <div class="container" >
               

<%
   
    mb_JsonParse mb_json;
    JsonObject_bean jsonobject_bean = null;
    User_bean user_bean = null;
   //int admin = Integer.parseInt(mb_JsonParse.user_bean.getAdmin());
   //
   int admin=0;
   Object arrayObj = null;
    JSONArray jsonarray;

   // String n=request.getParameter("userName");  
    //arrayObj = request.getAttribute("jsondata");
    JSONObject jsonObject1 = new JSONObject();
    jsonobject_bean = new JsonObject_bean();
    jsonObject1 = mb_JsonParse.jsonobject_bean.getJsonobject();
    arrayObj = mb_JsonParse.jsonobject_bean.getObj();
    jsonarray = mb_JsonParse.jsonobject_bean.getMoviesObj();
    
            /* TODO output your page here. You may use following sample code. */
             Object[]oa = null;
                oa= (Object[]) jsonarray.toArray();
                //JSONObject oa1= new JSONObject oa[1];
               // String some = oa1.getString("genre");
                        //a.getClass().getName()
               // oa1 = oa[1].toString();
               int i=0;
               //out.println(oa);
            String[][] movie_info=null;
           String[] movie_name = null;
           String[] language=null;

               for(Object o:oa){
                   
                //out.println(oa[i]);
                JSONParser parser1 = new JSONParser();  
               //out.println(oa[i]);

                  
                  jsonObject1 = new JSONObject();
                 try {
                    jsonObject1 =  (JSONObject) parser1.parse(oa[i].toString());
                 } catch (org.json.simple.parser.ParseException ex) {
                //Logger.getLogger(JavaParse.class.getName()).log(Level.SEVERE, null, ex);
                }
               //  var data = jsonObject1;
                 i++;
                
                                
                   
                 %>
                   <%  String x = (String) jsonObject1.get("movie_name");
                          String y = (String) jsonObject1.get("language");
                      %>
            
                     <div class="list-group-item" >
                      <h1>Movie Name: <% out.println(jsonObject1.get("movie_name"));%></h1>
                      <h4 class="list-group-item-heading">Genres: <% out.println(jsonObject1.get("genre"));%></h4>
                      <h4 class="list-group-item-heading">Language: <% out.println(jsonObject1.get("language"));%></h4>
                                         <button   class="btn btn-info pull-right" onclick="direct('+x+','+y')>Book</button>
                  <%--
                                           <button name="Edit"><%out.println(admin);%></button>
s  if(admin==1){'" + v.LibraryItemId + " '
                             %><button name="Edit">Edit</button>
                        <%}--%>

                     </div>
           
                
             
                  
                 
              <%                          
         
          // movie_name[i]= (String) jsonObject1.get("movie_name");
          // language[i]=(String) jsonObject1.get("language");
          // movie_info[i][j]={movie_name,language};
               }   
          //  session.setAttribute("movie_name", movie_name);
          // session.setAttribute("language",language);
         %>
             
                   

        </div>

<br />

<br />
 
<%
   //out.println("2nd Position: " + jsonarray);
%>
<br />
<%
   // out.println("isNull 3d position: " + data);
%>
<br />
<%
   // out.println("Mark:" + getMark);
%>
<br />
<%
   // out.println("City: " + ob);
%>

<footer>
                <center>            
                    <table cellpadding="10">

                    <tbody>
                        <tr>
                            <td colspan="3" > <%= new java.util.Date() %>  </td>
                            <td colspan="1">www.tcs.com   </td>
                            <td colspan="1">tcs@copyright</td>
                        </tr>
                    </tbody>
                    </table>
                </center>
            </footer>
</body>
</html>
