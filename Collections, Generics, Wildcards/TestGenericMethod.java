import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TestGenericMethod {
	
	public static void copyEmloyees(ArrayList<? extends Employee> source, ArrayList<Employee> destination) {
		for (Employee e : source) {
			destination.add(new Employee(e.getName()));
		}
	}

	public static void main(String[] args) {
		
		ArrayList<RetiredEmployee> retiredEmployees = new ArrayList<>();
		retiredEmployees.add(new RetiredEmployee("Tomo Cvijetiæ", 550));
		retiredEmployees.add(new RetiredEmployee("Mijo Veselinoviæ", 550));
		retiredEmployees.add(new RetiredEmployee("Slavojka Matiæ", 550));
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		copyEmloyees(retiredEmployees, employees);
		
		System.out.println(Arrays.deepToString(employees.toArray()));
		
	}

}
