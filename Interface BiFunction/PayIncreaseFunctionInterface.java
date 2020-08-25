import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class PayIncreaseFunctionInterface {

	public static void main(String[] args) {
		
		final int INCREASE_CAP  = 20;
		
		Person[] workers = new Person[3];
		workers[0] = new Person("Boris Jokiæ", 'E');
		workers[1] = new Person("Petar Petroviæ", 'C');
		workers[2] = new Person("Pero Petroviæ", 'E');
		List<Person> workersList = Arrays.asList(workers); 
		
		BiFunction<Person, Integer, Boolean> increaseEmployee = 
				(pers, percent) -> {
					System.out.println("Increase pay for employee " + pers.getName());
					return true;
				};
				
		BiFunction<Person, Integer, Boolean> increaseContractor =
				(pers, percent) -> {
					if (percent > INCREASE_CAP) {
						System.out.println("Can't increase pay more than " + INCREASE_CAP );
						return false;
					}
					System.out.println("Increase pay for contractor " + pers.getName());
					return true;
				};
		workersList.forEach(p -> {
			if (p.getWorkerStatus() == 'E') {
				p.validateIncreasePay(increaseEmployee, 30);
			}
			else if (p.getWorkerStatus() == 'C') {
				p.validateIncreasePay(increaseContractor, 30);
			}
		});		

	}

}
