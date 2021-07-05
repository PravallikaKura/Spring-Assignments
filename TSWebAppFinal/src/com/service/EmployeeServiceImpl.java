package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.MyConnection;
import com.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	public Employee getEmployee(String userId, String password) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee where loginId=? and password=?";
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(SELECT);
			pst.setString(1, userId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getInt(3));
				employee.setLoginId(rs.getString(4));
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Employee getEmployee(int empId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee where empId=?";

		con = MyConnection.getConnection();
		try {
			pst = con.prepareStatement(SELECT);
			pst.setInt(1, empId);
			rs = pst.executeQuery();
			if (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getInt(3));
				employee.setLoginId(rs.getString(4));
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insert(Employee employee) {
		Connection con = null;
		PreparedStatement pst = null;
		int status = 0;
		String INSERT = "insert into employee(empName,salary,loginId,password) values(?,?,?,?)";
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(INSERT);
			pst.setString(1, employee.getEmpName());
			pst.setFloat(2, employee.getSalary());
			pst.setString(3, employee.getLoginId());
			pst.setString(4, employee.getPassword());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public ArrayList<Employee> getAllEmployees() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SELECT = "select * from employee";
		con = MyConnection.getConnection();
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			pst = con.prepareStatement(SELECT);
			rs = pst.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setSalary(rs.getInt(3));
				employee.setLoginId(rs.getString(4));
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	public int delete(int empId) {
		Connection con = null;
		PreparedStatement pst = null;
		int status = 0;
		String DELETE = "delete from employee where empId = ?";
		try {
			con = MyConnection.getConnection();
			pst = con.prepareStatement(DELETE);
			pst.setInt(1, empId);
			status = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
