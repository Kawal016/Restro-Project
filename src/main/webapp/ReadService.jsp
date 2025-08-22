<%@page import="com.restro.model.ServicePojo" %>
<%@page import="java.util.ArrayList" %>
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
            <li><a href="ReadServiceModuleForDelUpdServlet5">Refresh</a></li>
        </ul>
    </nav>
    <div class="content">
        <h2> SERVICE DETAILS ARE:</h2><br>
        <%
       
        ArrayList<ServicePojo> arraylist=(ArrayList<ServicePojo>)session.getAttribute("service2data");
        int index=0;
        if(arraylist!=null)
        {
        for(ServicePojo sp:arraylist)
       {
      %> 
        <h3>TitleName : <%= sp.getTitle() %></h3> 
        <h3>Description : <%= sp.getDescription() %></h3> 
         <h3>DateTime: <%= sp.getDateTime() %></h3> 
      
         <form action=" DeleteServiceModuleServlet6" method="post">
          <input type="hidden" name="sno" value="<%= sp.getSno()%>">
           <br>
           <button>DELETE</button>
           <a href="UpdateService.jsp?index=<%= index %>" style="text-decoration:none;">UPDATE</a> 
         </form>
         <br>
         
         
        <br><br>  
      <% index++; }}
        else{
        %>
     </div>
    
     <% } %>
    <footer>
         <h4><%@include file="Message.jsp" %></h4>
        <p>&copy; 2024 Admin Panel. All rights reserved.</p>
         
    </footer>
</body>
</html>