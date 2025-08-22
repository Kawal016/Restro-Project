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
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


   <%
 
   int index=Integer.parseInt(request.getParameter("index"));
   ArrayList<ServicePojo> arraylist=(ArrayList<ServicePojo>)session.getAttribute("service2data");
   ServicePojo sp=arraylist.get(index);
  
   %>	
 
  
   
  <form action="updateServlet1" method="post">
    <input type="hidden" name="sno" value="<%= sp.getSno()%>">
    <label>ICON NAME</label><br>
      <input type="text" name="icon" value="<%= sp.getIconName()%>"><br>
    <label>TITLE</label><br>
      <input type="text" name="title" value="<%= sp.getTitle()%>"><br>
    <label>DESCRIPTION</label><br>
      <textarea name="description" rows="5" cols="21"><%= sp.getDescription() %></textarea>
        <br>  <button >UPDATE SERVICE</button>
        <input type="hidden" name="index" value="<%= index %>">
   </form>
  <%@include file="Message.jsp" %>
  
</body>
</html>