
public class Employee {

	 public int age; 
	    public String ln, fn; 
	  
	    // Constructor 
	    public Employee (int age, String ln, String fn) 
	    { 
	        this.age = age; 
	        this.ln = ln; 
	        this.fn = fn; 
	    }

		@Override
		public String toString() {
			return "Employee [age=" + age + ", ln=" + ln + ", fn=" + fn + "]";
		}
	    
	    
}
