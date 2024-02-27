<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>SIGNUP page</h1>
  
  <form:form action="save" modelAttribute="employee">
    Name:<form:input path="empName"/><br>
    <br>
    Email:<form:input path="empEmail"/><br>
    <br>
    Contact:<form:input path="empContact"/><br> 
    <br>
    Salary:<form:input path="empSalary"/><br>
    <br>
    <input type="submit">
  </form:form>
  
</body>
</html>