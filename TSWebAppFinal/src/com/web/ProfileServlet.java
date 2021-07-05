package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;
import com.dto.Employee;
import com.service.EmployeeServiceImpl;
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String loginId = (String)session.getAttribute("loginId");
		String password = (String)session.getAttribute("password");
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		Employee employee = employeeServiceImpl.getEmployee(loginId, password);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setAttribute("employee", employee); 
		RequestDispatcher rd = request.getRequestDispatcher("EmpProfile.jsp");
		rd.include(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}