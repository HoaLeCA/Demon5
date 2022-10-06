<%-- 
    Document   : average
    Created on : 5-Oct-2022, 9:22:58 AM
    Author     : levan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Average</title>
    </head>
    <body>
        <h1>Average Number</h1>
        
        <form action="average" method="get">
<!--            default action back to itslef, default method is GET-->
            <div>
                <label> Enter number:</label>
                <input type="number" name="number" value="">
                
            </div>
            
            <div>
                <input type="submit" value="Calculate Average">
                
                
            </div>
                                                       
        </form>
         
                          
        <form action="average" method="get">
                <input type="submit" value="Reset the Average">
            </form>
          <p> Average: ${average}</p>
        <c:if test="${error == true}">
                     <p>Please enter a number</p>
            </c:if>    
          
    </body>
</html>
