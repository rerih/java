
public class PayIncrease {

	public static void main(String[] args) {
		
		Person[] workers = new Person[3];
		
		workers[0] = new Person("Boris Jokiæ", 'E');
		workers[1] = new Person("Petar Petroviæ", 'C');
		workers[2] = new Person("Pero petroviæ", 'E');

		// lambda expression for increasing Employee's pay
		Payable increasePayForEmployee = (int percent) -> {
			return true;
		};
		
		// lambda expression for increasing Contractor's pay
		Payable increasePayForContractor = percent -> {
			if (percent > Payable.INCREASE_CAP) {
				System.out.println("Sorry, can't increase hourly rate more than " + Payable.INCREASE_CAP + "%" );
				return false;
			}
			return true;
		};
		
		for (Person p : workers) {
			if (p.getWorkerStatus() == 'E') 
				p.validatePayIncrease(increasePayForEmployee, 30);
			else if (p.getWorkerStatus() == 'C')
				p.validatePayIncrease(increasePayForContractor, 30);
		}
		
	}

}
