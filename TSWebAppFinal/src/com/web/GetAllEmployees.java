package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dto.Employee;
import com.service.EmployeeServiceImpl;

@WebServlet("/GetAllEmployees")
public class GetAllEmployees extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeServiceImpl employeeServiceImpl= new EmployeeServiceImpl();
		ArrayList<Employee> empList = employeeServiceImpl.getAllEmployees();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		request.setAttribute("empList", empList); 
		RequestDispatcher rd = request.getRequestDispatcher("ShowAllEmpJSTL.jsp");
		rd.include(request, response); 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}