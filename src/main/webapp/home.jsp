<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <table>
   
   <tr>
        <th>empId</th>
        <th>empName    </th>
        <th>empEmail   </th>
        <th>empContact</th>
        <th>empSalary</th>
        <th>edit</th>
        <th>delete</th>
   </tr> 
   
   <c:forEach var="emp" items="${emps}">
   
   <tr>
        <td>${emp.empId}</td>
        <td>${emp.empName}</td>
        <td>${emp.empEmail}</td>
        <td>${emp.empContact}</td>
        <td>${emp.empSalary}</td>
        <td><button><a href="edit?empId=${emp.empId }">Edit</a></button></td>
        <td><button><a href="delete?empId=${emp.empId }">delete</a></button></td>
        
   </tr>
    
     </c:forEach>  
    
   
    </table>
</body>
</html>