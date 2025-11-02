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



	@Override
	public List<Employee> getAllEmployeeByNames(String name) {
		
		String sql="Select * from empdetail Where name=?";
		
List<Employee>emps=new ArrayList<Employee>();
		

		try(Connection connection=DBUtility.getInstance().getDbConnection(); PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			
			preparedStatement.setString(1, name);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int empId= resultSet.getInt(1);
				String empName=resultSet.getString(2);
				double salary=resultSet.getDouble(3);
				String department=resultSet.getString(4);
				int age=resultSet.getInt(5);
				
				Employee emp=new Employee(empId, empName, salary, department, age);
				
				emps.add(emp);
				
			}
			
			
		}catch(Exception e) {
			throw new DAOException("Faild To get Employess By NAme");
		}
		
		
		return emps;
	}



	@Override
	public List<Employee>getEmpBySalary(double salary) {
		String sql = "SELECT * FROM empdetail WHERE salary = ?";
	    List<Employee> emps = new ArrayList<>();

	    try (Connection connection = DBUtility.getInstance().getDbConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        
	        preparedStatement.setDouble(1, salary);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int empId = resultSet.getInt("empid");
	            String empName = resultSet.getString("name");
	            double empSalary = resultSet.getDouble("salary");
	            String department = resultSet.getString("department");
	            int age = resultSet.getInt("age");

	            Employee emp = new Employee(empId, empName, empSalary, department, age);
	            emps.add(emp);
	        }

	    } catch (Exception e) {
	        throw new DAOException("Failed to get employees by salary: " + e.getMessage());
	    }

	    return emps;
	}



	@Override
	public Employee getEmpByEmpIDAndName(int empId, String name) {
		
		String sql = "SELECT * FROM empdetail WHERE empid = ? AND name = ?";
	    Employee emp = null;

	    try (Connection connection = DBUtility.getInstance().getDbConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        
	        preparedStatement.setInt(1, empId);
	        preparedStatement.setString(2, name);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int id = resultSet.getInt("empid");
	            String empName = resultSet.getString("name");
	            double salary = resultSet.getDouble("salary");
	            String department = resultSet.getString("department");
	            int age = resultSet.getInt("age");

	            emp = new Employee(id, empName, salary, department, age);
	        }

	    } catch (Exception e) {
	        throw new DAOException("Failed to get employee by ID and name: " + e.getMessage());
	    }

	    return emp;
	}



	@Override
	public List<Employee> findMaxSalaryEmployee() {
		
		String sql = "SELECT * FROM empdetail WHERE salary = (SELECT MAX(salary) FROM empdetail)";
	    List<Employee> emps = new ArrayList<>();

	    try (Connection connection = DBUtility.getInstance().getDbConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int empId = resultSet.getInt("empid");
	            String name = resultSet.getString("name");
	            double salary = resultSet.getDouble("salary");
	            String department = resultSet.getString("department");
	            int age = resultSet.getInt("age");

	            Employee emp = new Employee(empId, name, salary, department, age);
	            emps.add(emp);
	        }

	    } catch (Exception e) {
	        throw new DAOException("Failed to find employees with max salary: " + e.getMessage());
	    }

	    return emps;
	}



	@Override
	public List<Employee> findMinSalaryEmployee() {
		String sql = "SELECT * FROM empdetail WHERE salary = (SELECT MIN(salary) FROM empdetail)";
	    List<Employee> emps = new ArrayList<>();

	    try (Connection connection = DBUtility.getInstance().getDbConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int empId = resultSet.getInt("empid");
	            String name = resultSet.getString("name");
	            double salary = resultSet.getDouble("salary");
	            String department = resultSet.getString("department");
	            int age = resultSet.getInt("age");

	            Employee emp = new Employee(empId, name, salary, department, age);
	            emps.add(emp);
	        }

	    } catch (Exception e) {
	        throw new DAOException("Failed to find employees with max salary: " + e.getMessage());
	    }

	    return emps;
	}



	@Override
	public double findAvgSalary() {
		

	    String sql = "SELECT AVG(salary) AS avg_salary FROM empdetail";
	    double avgSalary = 0.0;

	    try (Connection connection = DBUtility.getInstance().getDbConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            avgSalary = resultSet.getDouble("avg_salary");
	        }

	    } catch (Exception e) {
	        throw new DAOException("Failed to find average salary: " + e.getMessage());
	    }

	    return avgSalary;
	}



	@Override
	public List<Employee> findAllSortedBySalaryDesc() {
		 String sql = "SELECT * FROM empdetail ORDER BY salary DESC";
		    List<Employee> emps = new ArrayList<>();

		    try (Connection connection = DBUtility.getInstance().getDbConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

		        ResultSet resultSet = preparedStatement.executeQuery();

		        while (resultSet.next()) {
		            int empId = resultSet.getInt("empid");
		            String name = resultSet.getString("name");
		            double salary = resultSet.getDouble("salary");
		            String department = resultSet.getString("department");
		            int age = resultSet.getInt("age");

		            Employee emp = new Employee(empId, name, salary, department, age);
		            emps.add(emp);
		        }

		    } catch (Exception e) {
		        throw new DAOException("Failed to sorted by salary (desc): " + e.getMessage());
		    }

		    return emps;
	}



	@Override
	public List<Employee> findAllSortedBySalaryAcen() {
		String sql = "SELECT * FROM empdetail ORDER BY salary ASC";
	    List<Employee> emps = new ArrayList<>();

	    try (Connection connection = DBUtility.getInstance().getDbConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int empId = resultSet.getInt("empid");
	            String name = resultSet.getString("name");
	            double salary = resultSet.getDouble("salary");
	            String department = resultSet.getString("department");
	            int age = resultSet.getInt("age");

	            Employee emp = new Employee(empId, name, salary, department, age);
	            emps.add(emp);
	        }

	    } catch (Exception e) {
	        throw new DAOException("Failed to . sorted by salary (ASC): " + e.getMessage());
	    }

	    return emps;
	}

}
