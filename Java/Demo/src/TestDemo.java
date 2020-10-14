import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestDemo {
	
	
	
	public static void main (String args[]) {
		ArrayList<Employee> ar = new ArrayList<Employee>(); 
        ar.add(new Employee(23,"Zhou","Yinan")); 
        ar.add(new Employee(31, "Wang", "nyc")); 
        ar.add(new Employee(21, "Chen", "jaipur")); 
  
        System.out.println("Unsorted"); 
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
  
        Collections.sort(ar, new SortByName());
        Collections.sort(ar,new SortByFN());
        
        System.out.println("Sorted");
        
        for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i)); 
		
	}

}
