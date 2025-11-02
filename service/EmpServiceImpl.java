package com.service;

import java.util.List;

import com.dao.EmpDao;
import com.dao.EmpDaoImpl;
import com.model.Employee;

public class EmpServiceImpl implements EmpService {

	EmpDao empDao=new EmpDaoImpl();
	
	@Override
	public boolean addEmp(Employee emp) {
		
		return empDao.saveEmp(emp)>0;
	}

	@Override
	public boolean updatEmp(Employee emp) {
		
		return empDao.updateEmp(emp)>0;
	}

	@Override
	public boolean deleteEmp(int id) {
		
		return empDao.deleteEmp(id)>0;
	}

	@Override
	public Employee getEmpById(int id) {
		
		return empDao.getEmpById(id);
		}

	@Override
	public List<Employee> getAllEmp() {
		
		return empDao.getAllEmployee();
	}

	@Override
	public List<Employee> getAllEmployeeByNames(String name) {
		
		return empDao.getAllEmployeeByNames(name);
	}

	@Override
	public List<Employee> getEmpsBySalary(double salary) {
		
		return empDao.getEmpBySalary(salary);
	}

	@Override
	public Employee getEmpByEmpIDAndName(int empId, String name) {
		
		return empDao.getEmpByEmpIDAndName(empId, name);
	}

	@Override
	public List<Employee> findMaxSalaryEmployee() {
		
		return empDao.findMaxSalaryEmployee();
	}

	@Override
	public List<Employee> findMinSalaryEmployee() {
		
		return empDao.findMinSalaryEmployee();
	}

	@Override
	public double findAvgSalary() {
		
		return empDao.findAvgSalary();
	}

	@Override
	public List<Employee> findAllSortedBySalaryDesc() {
		
		return empDao.findAllSortedBySalaryDesc();
	}

	@Override
	public List<Employee> findAllSortedBySalaryAcen() {
		return empDao.findAllSortedBySalaryAcen();
	}

}
