package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmpDao {
	
	int saveEmp(Employee emp);
	
	int deleteEmp(int empId);
	
	int updateEmp(Employee emp);
	
	Employee getEmpById(int id);
	
	List<Employee>getAllEmployee();
	
	

}
