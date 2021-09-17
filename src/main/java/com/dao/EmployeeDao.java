package com.dao;

import java.util.List;

import com.springentities.Employee;

public interface EmployeeDao {

	public int insert(Employee employee);
	
	public int update(Employee employee);
	
	public int delete(int id);
	
	public Employee getEmployee(int id);
	
	public List <Employee> getEmployees();
}
