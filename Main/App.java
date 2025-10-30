package com.Main;

import java.util.List;
import java.util.Scanner;

import com.model.Employee;
import com.service.EmpService;
import com.service.EmpServiceImpl;

public class App {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
        EmpService empService= new EmpServiceImpl();
	    
         int choice=0;
		
		
		do{
			
			System.out.println("+++++ EMPloyeee ManageMent System ");
			
			    System.out.println("1. Add Employee");
	            System.out.println("2. Update Employee");
	            System.out.println("3. Delete Employee");
	            System.out.println("4. Display All Employee");
	            System.out.println("5. Display Employee By ID");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            
	            choice = scanner.nextInt();
			
	            
	         switch(choice) {
	         
	         case 1:
	        	 
	        	 System.out.println("Enter Employee ID: ");
	        	 int empId=scanner.nextInt();
	        	 
	             scanner.nextLine();
                 System.out.println("Enter Employee Name: ");
                 String name = scanner.nextLine();
                 
                 System.out.println("Enter Employee Salary: ");
                 double salary = scanner.nextDouble();
                 
                 scanner.nextLine();
                 System.out.println("Enter Employee DepartMent: ");
                 String department = scanner.nextLine();
                 
                 System.out.println("Enter Employee Age: ");
                 int age = scanner.nextInt();
                 
                 Employee employee=new Employee(empId,name,salary,department,age);
                 
                 boolean employeeAdded=empService.addEmp(employee);
                 
                 if(employeeAdded)
                	 System.out.println("Employee Added Successfully ");
                 else
                	 System.out.println("Employee Not Added");
                 
                 break;
                 
                 
                 
	         case 2:
	        	 System.out.println("Enter Employee ID To Update ");
	        	 int empid=scanner.nextInt();
	        	 
	        	 scanner.nextLine();
                 System.out.println("Enter New Employee Name: ");
                 String Name = scanner.nextLine();
	        	 
                 
                 System.out.println("Enter New Employee Salary: ");
                 double Salary = scanner.nextDouble();
                 
                 scanner.nextLine();
                 System.out.println("Enter New Employee DepartMent: ");
                 String Department = scanner.nextLine();
                 
                 System.out.println("Enter NEw  Employee Age: ");
                 int Age = scanner.nextInt();
                 
                 
                 Employee employee2=new Employee(empid,Name,Salary,Department,Age);
                 
                 boolean updatedEmployee=empService.updatEmp(employee2);
                 
                 if(updatedEmployee)
                	 System.out.println("Employee Updated Suceesfully");
                 else
                	 System.out.println("Employee Not Updated");
                 
                 break;
                 
                 
                	 
	         case 3:
	        	 
	        	 System.out.println("Enter Employee Id To Delete");
                 int employeeID=scanner.nextInt();
                 
                 boolean deletedEmployee=empService.deleteEmp(employeeID);
                 
                 if(deletedEmployee)
                	 System.out.println("Employee Deleted Successfully !!");
                 else
                	 System.out.println("Employee Not Deleted");
                 
                 break;
                 
                 
                 
	         case 4:
	        	 
	        	 List<Employee>list=empService.getAllEmp();
	        	 
	        	 if(list.isEmpty()) {
	        		 
	        		 System.out.println("Employees Not Found");
	        		 
	        	 }else {
	        		 
	        		 for(Employee emp:list) {
	        			 System.out.println(emp);
	        		 }
	        		 
	        	 }
                	 
	        	 break;
	        	 
	        	 
	         case 5:
	        	 System.out.println("Enter Employee Id To Get Employee");
             int employeeId=scanner.nextInt();
             
             Employee employe=empService.getEmpById(employeeId);
             
             if(employe==null)
            	 System.out.println("Employee Not Found  !!");
             else
             
                  System.out.println(employe);
             
             break;
	        	 
	        	 
	        	 
	         case 6:
	        	 System.out.println("Thank You");
	        	 System.exit(0);
	        	 
	        	 
	        	 
	         }   
	         
		}while (choice != 6);
		
	}

        
        }

