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

@WebServlet("/ShowEmpServlet")
public class ShowEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		Employee employee = employeeServiceImpl.getEmployee(empId);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (employee != null) {
			request.setAttribute("employee", employee);
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmp.jsp");
			rd.include(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("AdminServlet");
			rd.include(request, response);
			out.print("<html><body><h3><center>Record not found</center></h3></body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
