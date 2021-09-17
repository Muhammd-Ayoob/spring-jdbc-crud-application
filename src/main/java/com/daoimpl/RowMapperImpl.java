package com.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper; 

import com.springentities.Employee;

public class RowMapperImpl implements RowMapper{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Employee employee=(Employee) context.getBean("employee");
		
		
		employee.setId(rs.getInt(1));
		
		employee.setName(rs.getString(2));
		
		employee.setCity(rs.getString(3));
		
		
		return employee;
	}

	
	
	

}
