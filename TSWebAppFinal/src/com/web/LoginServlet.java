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
import com.dto.Employee;
import com.service.EmployeeServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginId);
		session.setAttribute("password", password);
		session.setMaxInactiveInterval(10);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		Employee employee = employeeServiceImpl.getEmployee(loginId, password);

		if(loginId.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response); 					
		} 
		else if(employee!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeServlet");
			rd.forward(request, response); 	
		}

		else {
			out.println("<html>"); 
			out.println("<body>");
			out.println("<h1><center>Invalid Credentials</center></h1>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response); 					

			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}