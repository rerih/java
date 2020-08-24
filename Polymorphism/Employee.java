
public class Employee extends Person {
	
	public Employee(String name) {
		super(name);
		
	}
	
	//subclass implements the abstract method
	public boolean increasePay(int percent) {
		System.out.println("Increase salary by " + percent + "%");
		return true;
	}

}
