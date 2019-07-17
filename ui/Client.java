package ui;
import dto.*;
import exception.EmployeeException;
import service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) 
    {
        
        EmployeeServiceImpl employeeServiceImplObj = new EmployeeServiceImpl();
        
        Scanner sc = new Scanner(System.in);
        int ch;
        int id, salary;
        String name;
        
        while(true){
            System.out.println("1-Add Employee");
            System.out.println("2-Get All Employee Details");
            System.out.println("3-Get Employee By Id");
            System.out.println("4-Sorting based on employee id");
            System.out.println("5-Sorting based on employee name");
            System.out.println("6-Exit");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter the id");
                    id = sc.nextInt();
                    System.out.println("Enter the name");
                    name = sc.next();
                    boolean res=employeeServiceImplObj.validateName(name);
                    while(!res){
                    if(res==false)
                        System.out.println("name should contain only alphabets");
                    System.out.println("enter again");
                    name=sc.next();
                    res=employeeServiceImplObj.validateName(name);
                    }
                    System.out.println("Enter the salary");
                    salary = sc.nextInt();
                    boolean res1=employeeServiceImplObj.validateSalary(salary);
                    while(!res1){
                        if(res1==false)
                            System.out.println("salary should be greater than zero");
                        System.out.println("enter again");
                        salary=sc.nextInt();
                        res=employeeServiceImplObj.validateSalary(salary);
                        }
                    Employee employeeAddObj = new Employee(id, name, salary);
                    employeeServiceImplObj.insertEmployee(employeeAddObj);
                    break;
                case 2:
                HashMap<Integer, Employee> hmaps;
                try {
                    hmaps = employeeServiceImplObj.getAllEmployees();
                    System.out.println(hmaps);
                    if(hmaps!=null)
                    for (Map.Entry<Integer, Employee> maps : hmaps.entrySet()) {
                        System.out.println(maps.getKey() + " = " + maps.getValue());
                    }
                } catch (EmployeeException e) {
                    System.out.println(e);;
                } 
                    break;
                case 3:
                    System.out.println("Enter id");
                    id = sc.nextInt();
                    Employee employee;
                    try {
                        employee = employeeServiceImplObj.getEmployeeById(id);
                        System.out.println("ID  Name   Salary");
                        System.out.println(employee.getEmpId()+ " " +employee.getEmpName()+ " " +employee.getEmpSal());
                    } catch (EmployeeException e) {
                        System.out.println(e);;
                    }
                    break;
                    
                case 4:ArrayList<Employee> list=new ArrayList<Employee> ();
                	
                	list=employeeServiceImplObj.getSortedEmployeeById();
                	System.out.println(list);
                	break;
                case 5:
                	ArrayList<Employee> l=new ArrayList<Employee> ();
                	l=employeeServiceImplObj.getSortedEmployeeByName();
                	System.out.println(l);
                	break;
                case 6:
                    System.out.println("END");
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }
        }
        
    }
}
 
