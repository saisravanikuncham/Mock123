package dao;
import util.Sort;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import dto.Employee;
import exception.EmployeeException;
public class EmployeeDaoImpl {
    
    private static HashMap<Integer,Employee> map=new HashMap<Integer,Employee>();
    
    //Getter and Setter for map   
    public static void setMap(HashMap<Integer,Employee> map)
    {
        EmployeeDaoImpl.map=map;
    }  
    public static HashMap<Integer,Employee> getMap()
    {
        return map;
    }  
    //implement interface methods
    public void insertEmployee(Employee employee){
        map.put(employee.getEmpId(), employee);
        System.out.println("Employee Information stored successfully for " +employee.getEmpId());
    }
    
    public HashMap<Integer, Employee> getAllEmployees() throws EmployeeException{
        if(map.isEmpty()){
//            System.out.println(" No employee found");
         throw new EmployeeException();
            //throw Employee Exception;
        }
        else
            return map;
        
    }
    public Employee getEmployeeById(int id) throws EmployeeException{
        if(map.containsKey(id)){
            return map.get(id);
        }
        else
  throw new EmployeeException(); 
        
    }
    public ArrayList getSortedByEmpId()
    {
    	
    	ArrayList<Employee> list=new ArrayList(map.values());
    	Collections.sort(list); 
    	
    	return list;
    }
    public ArrayList getSortedByEmpName()
    {
    	Sort s=new Sort();
    	ArrayList<Employee> l=new ArrayList(map.values());
    	Collections.sort(l,s); 
    	
    	return l;
    }
}