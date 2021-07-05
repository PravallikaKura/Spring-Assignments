package com.dto;

public class Employee {
	private int empId;
	private String empName;
	private int salary;
	private String loginId;
	private String password;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, int salary, String loginId, String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.loginId = loginId;
		this.password = password;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
