<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.dto.Employee,java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList <Employee> empList = (ArrayList <Employee>)request.getAttribute("empList");
%>
<jsp:include page="AdminHome.jsp" />
	<table border=2 align=center>
		<tr>
			<th>Emp Id</th>
			<th>Emp Name</th>
			<th>Salary</th>
			<th>Login Id</th>
		</tr>
		<% for(Employee employee :empList ){ %>
		<tr>
			<td><%= employee.getEmpId()%> </td>
			<td><%= employee.getEmpName()%> </td>
			<td><%=employee.getSalary()%></td>
			<td><%=employee.getLoginId()%></td>
		</tr>
	  <%  } %>
	</table>
</body>
</html>