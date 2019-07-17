package util;
import java.util.*;
import dto.*;


public class Sort implements Comparator<Employee>{
	public int compare(Employee e,Employee f)
	
	{
		 return e.getEmpName().compareTo(f.getEmpName());
		
	}
	
}
