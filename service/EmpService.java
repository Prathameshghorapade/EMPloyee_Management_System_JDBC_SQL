package com.service;

import java.util.List;

import com.model.Employee;

public interface EmpService {

	boolean addEmp(Employee emp);
	
	boolean updatEmp(Employee emp);
	
	boolean deleteEmp(int id);
	
	Employee getEmpById(int id);
	
	List<Employee>getAllEmp();
	
	
List<Employee>getAllEmployeeByNames(String name);
	
List<Employee> getEmpsBySalary(double salary);
	
	Employee getEmpByEmpIDAndName(int empId,String name);
	
	
List<Employee> findMaxSalaryEmployee();
	
	List<Employee> findMinSalaryEmployee();
	
	double findAvgSalary();
	
	
List<Employee> findAllSortedBySalaryDesc();
	
	List<Employee> findAllSortedBySalaryAcen();
	
	
}
