package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.Employee;
import com.service.EmployeeServiceImpl;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empName = request.getParameter("empName");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setSalary(salary);
		employee.setLoginId(loginId);
		employee.setPassword(password);
		int status = employeeServiceImpl.insert(employee);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		if(status > 0){
			out.println("Registration Success..");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.include(request, response);  
		}else {
			out.println("Registration Un Success..");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.include(request, response);  
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
