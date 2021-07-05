package com.service;

import java.util.ArrayList;


import com.dto.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(String userId, String password);
	
	public Employee getEmployee(int empId);
	
	public int insert(Employee employee);
	
	public ArrayList<Employee> getAllEmployees();
	
	public int delete(int empId);

}
