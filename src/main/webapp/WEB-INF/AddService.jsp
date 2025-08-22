<%
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
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="ServiceModuleServlet1" method="post">
   <input type="text" name="iconnname" placeholder="Enter Icon Name">
   <input type="text" name="title" placeholder="Enter title">
   <input type="text" name="description" placeholder="Enter Description">
   <button>Add Service</button>
  </form>

</body>
</html>