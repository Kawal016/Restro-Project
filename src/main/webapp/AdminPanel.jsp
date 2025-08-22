<%
response.setHeader("Cache-Control", "no-Cache,no-store,must-revalidate");
String check=(String)session.getAttribute("AdminLogin");
if(check==null)
{
	 response.sendRedirect("AdminLogin.jsp");
	 return ;
}
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Panel</title>
<link rel="stylesheet" href="css/AdminStyle.css">
</head>
<body>
    <header>
        <h1>Admin Panel</h1>
    </header>
    <nav>
        <ul>
            <li><a href="AdminPanel.jsp">Home</a></li>
            <li><a href="ReadMessageServlet1">Read Message</a></li>
            <li><a href="AddService.jsp">Add Service</a></li>
            <li><a href="ReadServiceModuleForDelUpdServlet5">Read Service</a></li>
             <li><a href="AboutAdmin.jsp">About</a></li>
            <li><a href="#">Change Password</a></li>
            <li><a href="LogOutServlet1">Logout</a></li>
           
        </ul>
    </nav>
    <%@include file="Message.jsp" %>
    <div class="content">
        <h2>Welcome to the Admin Panel</h2>
        <p>This is the main content area where you can manage your admin tasks.</p>
    </div>
    <footer>
        <p>&copy; 2024 Admin Panel. All rights reserved.</p>
    </footer>
</body>
</html>