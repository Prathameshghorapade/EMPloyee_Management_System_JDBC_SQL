package com.model;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private int empId;
	
	private String name;
	
	private double  salary;
	
	private  String  department;
	
	private int  age;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee(int empId, String name, double salary, String department, int age) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", age=" + age + "]";
	}
	

}
