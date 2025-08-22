<%
   String message=(String)session.getAttribute("Message");
   if(message!=null)
   {

      if(message.contains("SUCCESSFULY"))
       {
%>
    	  <span style="color:green"> <%= message %> </span>
<% 
       }
      else
      {
%>  
            <span style="color:red"> <%= message %> </span>
  
<%     
      }
     session.removeAttribute("Message");
   } 
 %>