package service;

 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

 

import dao.*;
import dto.Employee;
import exception.EmployeeException;

 

public class EmployeeServiceImpl  {
     EmployeeDaoImpl  employeeDaoImplObj=new  EmployeeDaoImpl();
      public void insertEmployee(Employee emp) {
          employeeDaoImplObj.insertEmployee(emp);
      }
      public HashMap<Integer,Employee>getAllEmployees() throws EmployeeException{
          try {
          HashMap<Integer,Employee> hm;
          hm=employeeDaoImplObj.getAllEmployees();
          return  hm;
      }catch(Exception e) {
          System.out.println(e);
      }
          return null;
      }
      public Employee getEmployeeById(int id)throws EmployeeException{
          try {
         Employee e= employeeDaoImplObj.getEmployeeById( id);
         return e;
      }catch(Exception e) {
          System.out.println(e);
      }
          return null;
          }
      
      public boolean validateName(String name) {
          
    
          if(Pattern.matches("[A-Z][a-z]*", name)&&name.length()>=3) {
              return true;
      }else
        return false;
         
}
      public boolean validateSalary(int salary) {
          if(salary<0)
              return false;
          else 
              return true;
      }
      //public L sortedHashMap<Integer,String> hm
      public ArrayList<Employee> getSortedEmployeeById()
      {
    	  ArrayList<Employee> list=new ArrayList<Employee> ();
    	  list=employeeDaoImplObj.getSortedByEmpId();
    	  
    	  return list;
      }
      public ArrayList<Employee> getSortedEmployeeByName()
      {
    	  ArrayList<Employee> list;

    	  list=employeeDaoImplObj.getSortedByEmpName();
    	  
    	  return list;
      }
}
 