<%-- 
    Document   : jsontest
    Created on : 21 Feb, 2017, 11:51:06 AM
    Author     : tcs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>  
    <head>  
    <meta content="text/html; charset=utf-8">  
    <title>JSON parsing</title>  
    <script type="application/javascript">  
    function load()  
    {  
       //var url="http://date.jsontest.com/"
       var url = "http://10.138.77.211:50003/getmovielist";//use any url that have json data  
       var request;  
       if(window.XMLHttpRequest){    
        request=new XMLHttpRequest();//for Chrome, mozilla etc  
       }    
       else if(window.ActiveXObject){    
        request=new ActiveXObject("Microsoft.XMLHTTP");//for IE only  
       } 

       request.onreadystatechange  = function(){  
          if (request.readyState == 4  )  
          {  
            
            var jsonObj = JSON.parse(request.responseText);//JSON.parse() returns JSON object  
            document.getElementById("check").innerHTML =  "I am inside the java script" ;  

            alert(jsonObj);
            document.getElementById("movies").innerHTML =  jsonObj.time.toString();              //System.println(jsonObj);  
          }  
       }  
       request.open("GET", url, true);  
       request.send();  
       
    }  
    </script>  
    </head>  
    <body>  
    <p id="check">Hello</p>
    print the output please: <p id="movies"></p><br/>
        <jsp:include page="mb_corosel.jsp" />
 
      
    <button type="button" onclick="load()">Load Information</button>  
    </body>  
    </html>  