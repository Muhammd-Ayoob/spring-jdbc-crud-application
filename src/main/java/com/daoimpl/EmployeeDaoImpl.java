package com.daoimpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dao.EmployeeDao;
import com.springentities.Employee;

public class EmployeeDaoImpl implements EmployeeDao  {

	//Jbbc object to fire sql Queries
	private JdbcTemplate jdbcTemplate;
	
	
	//Method to insert data in database
	public int insert(Employee employee) {
		
		String query="insert into employee(emp_name, city) values(  '"+employee.getName()+"','"+employee.getCity()+"')";  
		
		this.jdbcTemplate.update(query);
		
		return 0;
	}
	
	
	//Method to update any row in database table
	public int update(Employee employee)
	{
		String query="update employee set emp_name='"+employee.getName()+"',city='"+employee.getCity()+"' where id='"+employee.getId()+"' ";
		
			    return jdbcTemplate.update(query);  
		
	}
	
	
	
	
	
	//Method to delete any row from database table
	public int delete(int id)
	{
		
		String query="delete from employee where id='"+id+"' ";  
		
	    return jdbcTemplate.update(query);  
		
	}
	
	
	
	//Method to fetch a single row from database
	public Employee getEmployee(int id)
	{
		String query = "SELECT * FROM employee WHERE id = ?";
		
		RowMapper rowMapper = new RowMapperImpl();
		
		Object obj[]= {id};
		
		Employee employee= (Employee) this.jdbcTemplate.queryForObject(query, obj, rowMapper);
		
		return employee;
	}
	
	
	
	
	//Method to Fetch All rows from database
	public List <Employee> getEmployees()
	{
		String query="select *from employee";
		
		List<Employee> list= this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return list;
	}
	
	
	
	
	
	

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
