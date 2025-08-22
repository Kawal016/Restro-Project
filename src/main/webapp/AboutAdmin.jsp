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
<html>
<head>
<meta charset="UTF-8">
 <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            padding: 50px;
            display: flex;
            justify-content: center;
        }

        .upload-box {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            text-align: center;
        }

        .upload-box input[type="file"] {
            margin: 20px 0;
            padding: 10px;
        }

        .upload-box button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .upload-box button:hover {
            background-color: #45a049;
        }
    </style>
<title>Image Upload</title>
</head>
<body>
<div class="upload-box">
    <h2>Upload an Image</h2>
    <form action="AboutUploadImageServlet1" method="post" enctype="multipart/form-data">
        <input type="file" name="image" accept="image/*" required><br>
        <button type="submit">Upload</button>
    </form>
    <%@include file="Message.jsp" %>
</div>
</body>
</html>