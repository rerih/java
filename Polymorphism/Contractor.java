
public class Contractor extends Person {
	
	public Contractor(String name) {
		super(name);	
	}
	
	//subclass implements the abstract method
	public boolean increasePay(int percent) {
		if (percent < Person.INCREASE_CAP) {
			System.out.println("Increase hourly rate by " + percent + "%");
			return true;
		}
		else {
			System.out.println("Sorry, can't increse hourly rate by more than " + Person.INCREASE_CAP + "%");
			return false;
		}
	}

}
