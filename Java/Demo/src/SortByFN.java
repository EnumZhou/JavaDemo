import java.util.Comparator;

public class SortByFN implements Comparator<Employee>{
	public int compare(Employee a, Employee b) 
    { 
        return a.fn.compareTo(b.fn); 
    }

}
