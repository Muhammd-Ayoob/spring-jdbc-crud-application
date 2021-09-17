package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.EmployeeDao;
import com.springentities.Employee;

public class Test {

	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		EmployeeDao dao=(EmployeeDao) context.getBean("edao");
		
		Employee employee=(Employee) context.getBean("employee");
		
		/*employee.setName("Danish");
		employee.setCity("Naseer Abad");
		dao.insert(employee);*/
		
		
		
		/*
		 * employee.setName("Naresh kumar");
		employee.setCity("New chhor");
		employee.setId(7);
		dao.update(employee);
		System.out.println("Updated");*/
		
		
		
		//dao.delete(4);
		
		
		
		
		/*Employee employee2=dao.getEmployee(2);
		
		System.out.println(employee2);*/
		
		
		
		List<Employee> list=dao.getEmployees();
		
		for(Employee employee2: list)
		{
			System.out.println(employee2);
		}
		

	}
}
