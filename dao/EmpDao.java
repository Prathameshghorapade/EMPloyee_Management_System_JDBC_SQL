package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmpDao {
	
	int saveEmp(Employee emp);
	
	int deleteEmp(int empId);
	
	int updateEmp(Employee emp);
	
	Employee getEmpById(int id);
	
	List<Employee>getAllEmployee();
	
	
	List<Employee>getAllEmployeeByNames(String name);
	
	List<Employee> getEmpBySalary(double salary);
	
	Employee getEmpByEmpIDAndName(int empId,String name);
	
	
	
	List<Employee> findMaxSalaryEmployee();
	
	List<Employee> findMinSalaryEmployee();
	
	double findAvgSalary();
	
	
	List<Employee> findAllSortedBySalaryDesc();
	
	List<Employee> findAllSortedBySalaryAcen();

	
	
	
	
	
	
	
	
	
	
	
	

}
