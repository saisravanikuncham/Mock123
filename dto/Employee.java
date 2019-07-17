package dto;
import java.util.*;

    public class Employee implements Comparable<Employee>{
public Employee() {
    
}
        private int empId;
        private String empName;
        private int empSal;
        // Used to sort movies by year 
        public int compareTo(Employee e) 
        { 
            return this.empId- e.empId; 
        } 
        
        //public getters and setters
        
        public int getEmpId(){
            return empId;
        }
        
        public String getEmpName(){
            return empName;
        } 
        
        public int getEmpSal(){
            return empSal;
        }
        
        public void setEmpId(int empId){
            this.empId = empId;
        }
        
        public void setEmpName(String empName){
            this.empName = empName;
        }
        
        public void setEmpSal(int empSal){
            this.empSal = empSal;
        }
        
        // public 3 argument constructor in the order empId,empName,empSal
        public Employee(int empId, String empName, int empSal){
            this.empId = empId;
            this.empName = empName;
            this.empSal = empSal;
        }

 

        @Override
        public String toString() {
            return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
        }
    }