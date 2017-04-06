<%-- 
    Document   : mb_corosel
    Created on : 2 Mar, 2017, 1:59:23 PM
    Author     : tcs
--%>
  
<!DOCTYPE html>  
<html lang="en">  
  <head>  
     <title></title>  
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  
  </head>  
<style>  
  .carousel-inner > .item > img,  
  .carousel-inner > .item > a > img {  
      width: 80%;  
      margin: auto;  
  }  
</style>  
  
  <body>  
  
<div class="container">  
  
<div id="myCarousel" class="carousel slide" data-ride="carousel">  
    <!-- Indicators -->  
    <ol class="carousel-indicators">  
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>  
      <li data-target="#myCarousel" data-slide-to="1"></li>  
      <li data-target="#myCarousel" data-slide-to="2"></li>  
    </ol>  
  
    <!-- Wrapper for slides -->  
    <div class="carousel-inner" role="listbox">  
      <div class="item active">  
        <img src="images/jokes1.jpg" alt="jokes 1" >  
      </div>  
  
      <div class="item">  
        <img src="images/jokes2.jpg" alt="jokes 2" >  
      </div>  
      
      <div class="item">  
        <img src="images/jokes3.jpg" alt="jokes 3" >  
      </div>  
    </div>  
  
    <!-- Left and right controls -->  
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">  
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>  
      <span class="sr-only">Previous</span>  
    </a>  
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">  
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>  
      <span class="sr-only">Next</span>  
    </a>  
</div><!-- corousel end -->  
  
</div>  
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
  </body>  
</html>  