<%-- 
    Document   : mb_movie_info_theaters
    Created on : 23 Mar, 2017, 3:35:14 PM
    Author     : tcs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="moviebooking.mb_Movie_info"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <title>Movie Details</title>
 <style>
     #main div {
  display: inline-block;
}
     ul.nav {
    width:100%;
    margin:0 auto;
    padding:0;
    list-style:none;
    background-color:black;
    text-align:center;
    font-family: sans-serif; 
}
#info{
    text-align:center;
    padding:12px 0 13px 0;
    margin:0;
    display:block;
}
.nav li { 
    display:inline-block;
    width:33%;
    margin:0;
    padding:0;
}
.nav a {
    text-align:center;
    padding:12px 0 13px 0;
    margin:0;
    display:block;
}
.nav a:hover { 
    background:black;
    border:none;
}

ul.nav li:first-child a{
    border:none;
}
ul.nav li:last-child a {
    border:none;
}
 </style>
    </head>
    <body>
        <div class="container">
            <%
                mb_Movie_info mb_movieinfo = new mb_Movie_info();
                String name = mb_movieinfo.name;
                String lang = mb_movieinfo.language;
                %>
  <div class="jumbotron" id="main">
      <div span="1" class="right-col ">
          <img height="300px" width="250px" src="https://easyecom.in/images/no-image.png">
      </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <div class="center-col">
           <h1><%out.println(name);%></h1>
           <p>Language:<%out.println(lang);%></p>
      </div>
     
   
  </div>
       <nav class="navbar navbar-inverse">
  <div class="container-fluid">
     <ul class="nav navbar-nav">
      <li ><a href="#">Theaters</a></li>
      <li><a href="#">Reviews</a></li>
      <li><a href="#">Cast</a></li>

    </ul>
    
  </div>
</nav>
  <p></p>
  <p></p>
</div>
    </body>
</html>
