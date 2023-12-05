<%-- 
    Document   : personView
    Created on : Dec 4, 2023, 5:40:31 PM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <script>
            var apiEntryId = 0;
                 //function that receives cookie name to check and returns cookie value
              function getCookie(name) {
                var value = "; " + document.cookie;
                var parts = value.split("; " + name + "=");
                if (parts.length === 2) return parts.pop().split(";").shift();
            }
            
      
                var entryId = getCookie("entryId");
               
                console.log(entryId);
        </script>
    </body>
</html>
