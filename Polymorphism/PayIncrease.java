
// Program uses polymorphism. Instead of having different methods for different types of workers, we are using 
// polymorphic behavior to the method increasePay(). Different business logic is applied depending on the type of the object.
// The actual object type will be evaluated during the run time. This is called run-time binding or late binding.

public class PayIncrease {

	public static void main(String[] args) {
		Person[] workers = new Person[3];
		
		workers[0] = new Employee("Boris Jokiæ");
		workers[1] = new Contractor("Petar Petroviæ");
		workers[2] = new Employee("Pero Petriæ");
		
		for (Person p : workers) {
			p.promote(30);
		}

	}

}
