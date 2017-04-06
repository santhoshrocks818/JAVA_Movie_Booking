
<%-- 
    Document   : mb_login
    Created on : 2 Feb, 2017, 5:59:49 PM
    Author     : tcs@975087:Santhosh Nimmani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Booking</title>
        <SCRIPT type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
        </SCRIPT>
    </head>
    <style>
        .whitetext{
            color: white
        }
        table{
            border:3px blue
        }
       #brandingtcs{
            margin: 15px 30px 0 21px;
            background-image: url(http://fresherswalkin.careerfriend.in/wp-content/uploads/sites/8/2016/01/TCS-Logo.png);
            background-position: center;
            background-repeat: no-repeat;
            height: 192px;
            padding-top: 5px;
        }
        #tcslogo{
            background-repeat: no-repeat;
            float: left;
            width: 272px;
            height: 18px;
        }
        
    </style>
       
</table>
    <body onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="" background="http://cdn.wonderfulengineering.com/wp-content/uploads/2014/09/blue-wallpaper-36.jpg">
        <div id="brandingtcs">
            <div id="tcslogo"></div>
        </div> 

        <form method="post" action="Home">
            <center>
            <div>
            <table border="0.5" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th class="whitetext" colspan="2"><h2 align="center">Identify yourself</h2></th>
                    </tr>
                </thead>
                <tbody>
                    <tr><%--Email ID--%>
                        <td class="whitetext">Email ID</td>
                        <td><input type="email" name="email" value="" /></td>
                    </tr>
                    <tr><%--Password--%>
                        <td class="whitetext">Password</td>
                        <td><input type="password" name="pass" value="" /></td>           
                    
                    </tr>                    
                    <tr ><%--Submit button--%>
                        <td colspan="2"><input  type="submit" value="Login" style="float: right"/></td>
                    </tr>
                    <tr>
                        <td class="whitetext" colspan="2">Yet Not Registered!! <a class="whitetext" href="mb_reg.jsp">Register Here</a></td>
                    </tr>
                </tbody>
            </table>
            </div>
            </center>
        </form>
  
<footer>
                <center>            
                    <table cellpadding="10">

                    <tbody>
                        <tr>
                            <td colspan="3" > <%= new java.util.Date() %>       </td>
                            <td colspan="1">&ensp;&ensp;</td>
                            <td colspan="1">www.tcs.com&ensp;&ensp;</td>
                            <td colspan="1">NextGen@tcscopyright</td>
                        </tr>
                           
                    </tbody>
                    </table>
                </center>
            </footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
<%--<%

response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
    if(session.getAttribute("token")==null){
    response.sendRedirect(request.getContextPath() + "/mb_logout.jsp");

}
%>--%>
    </body>
</html>
