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
import com.service.EmployeeServiceImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId =	Integer.parseInt(request.getParameter("empId"));
		EmployeeServiceImpl employeeServiceImpl =new EmployeeServiceImpl();	
		int x = employeeServiceImpl.delete(empId);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		if(x > 0) {
			out.println("<h3>Record deleted..");
			RequestDispatcher rd = request.getRequestDispatcher("GetAllEmployees");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
