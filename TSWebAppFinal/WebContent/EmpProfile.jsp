<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dto.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=2 align=center>
		<tr>
			<th>EmpId</th>
			<th>EmpName</th>
			<th>Salary</th>
			<th>Login ID</th>
		</tr>
		<tr>
			<td>${employee.empId}</td>
			<td>${employee.empName}</td>
			<td>${employee.salary}</td>
			<td>${employee.loginId}</td>
		</tr>
	</table>
</body>
</html>