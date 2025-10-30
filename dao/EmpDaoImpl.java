package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exception.DAOException;
import com.model.Employee;
import com.utility.DBUtility;

public class EmpDaoImpl implements EmpDao {

	@Override
	public int saveEmp(Employee emp) {
	 
		String sqlQuery="Insert Into empdetail values(?,?,?,?,?)";
		int noOFRowsAffected=0;
		
		try( Connection con= DBUtility.getInstance().getDbConnection(); PreparedStatement preparedStatement=con.prepareStatement(sqlQuery)){
			
			preparedStatement.setInt(1, emp.getEmpId());
			preparedStatement.setString(2, emp.getName());
			preparedStatement.setDouble(3,emp.getSalary());
			preparedStatement.setString(4, emp.getDepartment());
			preparedStatement.setInt(5,emp.getAge());
			
			noOFRowsAffected=preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			throw new DAOException("Failed To Save");
		}
		
		return noOFRowsAffected;
	}
	
	

	@Override
	public int deleteEmp(int empId) {
		
		String query="Delete from empdetail Where empId=? ";
		int noOfRowsAffected=0;
		
		try( Connection connection= DBUtility.getInstance().getDbConnection(); PreparedStatement preparedStatement=connection.prepareStatement(query) ){

			preparedStatement.setInt(1,empId);
			noOfRowsAffected=preparedStatement.executeUpdate();
			
		}catch( Exception e) {
			throw new DAOException("Failed To Delete");
		}
		
		return noOfRowsAffected;
	}
	
	
	
	

	@Override
	public int updateEmp(Employee emp) {
	
		String sqlQuery="Update empdetail Set name=?,salary=?,department=?,age=? Where empId=?";
		int noOfRowsAffected=0;
		
		try( Connection connection= DBUtility.getInstance().getDbConnection(); PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery)){
			
			preparedStatement.setString(1, emp.getName());
			preparedStatement.setDouble(2, emp.getSalary());
			preparedStatement.setString(3, emp.getDepartment());
			preparedStatement.setInt(4, emp.getAge());
			preparedStatement.setInt(5,emp.getEmpId());
			
			noOfRowsAffected=preparedStatement.executeUpdate();
			
			
		}catch(Exception e) {
			throw new DAOException("Failed To Update");
		}
		
		
		return noOfRowsAffected;
	}

	@Override
	public Employee getEmpById(int id) {
		
		String sql="Select * from empdetail Where empId=?";
		
		Employee emp=null;
		
		try(Connection connection=DBUtility.getInstance().getDbConnection(); PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
		 
		 if(resultSet.next()) {
			 
			 emp=new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getInt(5));
			 
		 }
			
		}catch(Exception e) {
			throw new DAOException("Failed To get Employee");
		}
		
		return emp;
	}
	
	

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee>emps=new ArrayList<Employee>();
		
		String sql="select * from empdetail";

		try(Connection connection=DBUtility.getInstance().getDbConnection(); PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int empId= resultSet.getInt(1);
				String name=resultSet.getString(2);
				double salary=resultSet.getDouble(3);
				String department=resultSet.getString(4);
				int age=resultSet.getInt(5);
				
				Employee emp=new Employee(empId, name, salary, department, age);
				
				emps.add(emp);
				
			}
			
			
		}catch(Exception e) {
			throw new DAOException("Faild To get All Employess");
		}
		
		
		return emps;
	}

}
