import java.util.Comparator;

public class SortByName implements Comparator<Employee> 
{ 
    
    public int compare(Employee a, Employee b) 
    { 
        return a.ln.compareTo(b.ln); 
    }
}

