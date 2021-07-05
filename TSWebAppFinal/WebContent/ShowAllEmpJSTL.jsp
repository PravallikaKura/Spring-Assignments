<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="AdminHome.jsp" />
	<table border=2 align=center>
		<tr>
			<th>Emp Id</th>
			<th>Emp Name</th>
			<th>Salary</th>
			<th>Login Id</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach var="employee" items="${empList}">
			<tr>
			<td>${employee.empId} </td>
			<td>${employee.empName} </td>
			<td>${employee.salary}</td>
			<td>${employee.loginId}</td>
			<td><a href='DeleteServlet?empId=${employee.empId}'>Delete</a></td>
		</tr>
	  </c:forEach>
		
	</table>

</body>
</html>