
public abstract class Person {

	private String name;
	private String address;
	
	public static final int INCREASE_CAP = 20; 
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return "Person's name is " + name;
	}
	
	public void changeAddresss(String address) {
		this.address = address;
	}
	// abstract method
	public abstract boolean increasePay(int percent);
	
    // method uses the abstract method. By the time the concrete class is instantiated, 
	// the method increasePay()  will be implemented. 
	public void promote(int percent) {
		System.out.println("Promoting a worker...");
		increasePay(percent);
	}
}
