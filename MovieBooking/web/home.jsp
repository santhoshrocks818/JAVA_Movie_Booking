<%-- 
    Document   : mb_home
    Created on : 16 Feb, 2017, 2:26:27 PM
    Author     : tcs@975087:Santhosh Nimmani
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <style>    
        ul#nav_container {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }
        li{
            float: right;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
        }
        li a {
            float: right;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        div.relative {
            position: relative;
            height: 200px;
            border: 3px solid #000000;
        } 

        div.absolute {
             position: absolute;
             bottom: 8px;
             right: 16px;
             font-size: 18px; 
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    
    <body>
        <ul id="nav_container">
            <li><a class="active" href="mb_login.jsp">Logout</a></li>
            <li><a href="#Home">Home</a></li>
            <li>Location:<select name="Location">
                    <option>Select</option>
                    <option>Hyderabad</option>
                    <option>Vijayawada</option>
                    <option>Visakapatanam</option>
                </select>
            </li>
        </ul>
        <table>
             <c:forEach items="${list}" var="item">
             <tr>
             <td><c:out value="${item}" /></td>
             </tr>
             </c:forEach>
        </table>
        <div class="relative">
            <h1>Movie Name:</h1><p id="Moviename"><%request.getParameter("Moviename");%></p>
            <p>Genres:</p><p id="Genres">
            <p>Language:</p><p id="Language">
        <div class="absolute"> <button type="submit" >Book</button></div>
        </div>
        <div class="relative"><h1>Movie Name:</h1><p>Genres:</p><p>Language:</p>
        <div class="absolute"> <button type="submit" >Book</button></div>
        </div>
        <div class="relative"><h1>Movie Name:</h1><p>Genres:</p><p>Language:</p>
        <div class="absolute"> <button type="submit" >Book</button></div>
        </div>
                <footer>
                <center>            
                    <table cellpadding="10">

                    <tbody>
                        <tr>
                            <td colspan="3"> <%= new java.util.Date() %></td>
                            <td colspan="1">www.tcs.com</td>
                            <td colspan="1">tcs@copyright</td>
                        </tr>
                           
                    </tbody>
                    </table>
                </center>
            </footer>
    </body>
    
</html>
