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
	            System.out.println("6. Display Employee By Name");
	            System.out.println("7. Display Employee By Salary");
	            System.out.println("8. Display Employee By ID and Name");
	            System.out.println("9. Maximum Salary Employees");
	            System.out.println("10. Minimum Salary Employees");
	            System.out.println("11. Average Salary Employee");
	            System.out.println("12. Salary Ascending");
	            System.out.println("13. Salary Decending");
	            System.out.println("14. Exit");
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
	        	 scanner.nextLine();
	        	 System.out.println("Enter Employee Name To Get Employee");
             String employeeName=scanner.nextLine();
             
             List<Employee> employ=empService.getAllEmployeeByNames(employeeName);
             
             if(employ==null || employ.isEmpty())
            	 System.out.println("Employee Not Found  !!");
             else
             
                  System.out.println(employ);
             
             break;
	        	 
	         case 7:
	        	 System.out.println("Enter Employee Salary To Get Employee");
             double salaryy=scanner.nextDouble();
             
             List<Employee> emp=empService.getEmpsBySalary(salaryy);
             
             if(emp.equals(null))
            	 System.out.println("Employee Not Found  !!");
             else
             
                  System.out.println(emp);
             
             break;
             
	         case 8:
	        	    System.out.println("Enter Employee ID To Get Employee: ");
	        	    int id = scanner.nextInt();
	        	    scanner.nextLine(); // consume newline

	        	    System.out.println("Enter Employee Name: ");
	        	    String namee = scanner.nextLine();

	        	    Employee emps = empService.getEmpByEmpIDAndName(id, namee);

	        	    if (emps == null) {
	        	        System.out.println("Employee Not Found !!");
	        	    } else {
	        	        System.out.println(emps);
	        	    }

	        	    break;
	        	    
	        	    
	         case 9:

	        	 List<Employee> maxSalaryEmps = empService.findMaxSalaryEmployee();

	        	    if (maxSalaryEmps == null) {
	        	        System.out.println("Employee Not Found with MAx Salary !!");
	        	    } else {
	        	        System.out.println(maxSalaryEmps);
	        	    }

	        	    break;
	        	    
	        	    
	         case 10:
	        	 List<Employee> minSalaryEmps = empService.findMinSalaryEmployee();
	        	    if (minSalaryEmps == null) {
	        	        System.out.println("Employee Not Found  with Minimum Salary!!");
	        	    } else {
	        	        System.out.println(minSalaryEmps);
	        	    }

	        	    break;
	        	    
	        	    
	         case 11:
	        	 double avg = empService.findAvgSalary();
	        	    if (avg==0) {
	        	        System.out.println("Employee Not Found  with Average Salary!!");
	        	    } else {
	        	        System.out.println(avg);
	        	    }

	        	    break;
	        	    
	         case 12:
	        	 List<Employee>salaryAcending = empService.findAllSortedBySalaryAcen();
	        	    if (salaryAcending==null) {
	        	        System.out.println("Employee Not Found !!");
	        	    } else {
	        	        System.out.println(salaryAcending);
	        	    }

	        	    break;
	        	    
	        	    
	         case 13:
	        	 List<Employee>salaryDecending = empService.findAllSortedBySalaryDesc();
	        	    if (salaryDecending==null) {
	        	        System.out.println("Employee Not Found !!");
	        	    } else {
	        	        System.out.println(salaryDecending);
	        	    }

	        	    break;
             
	        	 
	         case 14:
	        	 System.out.println("Thank You");
	        	 System.exit(0);
	        	 
	        	 
	        	 
	         }   
	         
		}while (choice != 14);
		
	}

        
        }

