<% 
response.setHeader("Cache-Control", "no-Cache,no-store,must-revalidate");
String check=(String)session.getAttribute("AdminLogin");
if(check==null)
{
	 response.sendRedirect("AdminLogin.jsp");
	 return ;
}
%>

<%@page import="com.restro.model.ServicePojo" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>READ SERVICE</title>
<style>
    /* Reset default styles */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body {
        font-family: Arial, sans-serif;
    }
    /* Header styles */
    header {
        background-color: #333;
        color: #fff;
        padding: 10px;
    }
    header h1 {
        margin: 0;
    }
    /* Navigation styles */
    nav {
        background-color: #f0f0f0;
        padding: 10px;
    }
    nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }
    nav ul li {
        display: inline;
        margin-right: 10px;
    }
    nav ul li a {
        color: #333;
        text-decoration: none;
        padding: 5px 10px;
        border-radius: 5px;
    }
    nav ul li a:hover {
        background-color: #ddd;
        color: #333;
    }
    /* Main content styles */
    .content {
     padding-bottom:330px;
    }
    /* Footer styles */
    footer {
        background-color: #333;
        color: #fff;
        padding: 10px;
        text-align: center;
    }
</style>
</head>
<body>
    <header>
        <h1>Admin Panel</h1>
    </header>
    <nav>
        <ul>
            <li><a href="AdminPanel.jsp">Home</a></li>
        </ul>
    </nav>
    <div class="content">
    <br>
        <h2> ADD SERVICES:</h2><br>
       <form action="ServiceModuleServlet1" method="post">
         <input type="text" name="iconname" placeholder="Enter Icon Name"><br>
         <input type="text" name="title" placeholder="Enter title"><br>
         <input type="text" name="description" placeholder="Enter Description"><br>
       <br>  <button>Add Service</button>
      </form>
      <br>
      <h4><%@include file="Message.jsp" %></h4>
     <% session.removeAttribute("Message"); %>
     </div>
     
    <footer>
        <p>&copy; 2024 Admin Panel. All rights reserved.</p>
    </footer>
</body>
</html>

