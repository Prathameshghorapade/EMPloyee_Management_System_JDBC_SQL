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

}
