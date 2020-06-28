import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine();
		
		if (in.equals("something")) {
			System.out.println("hello you");
		}
		else if (in.equals("nothing")) {
			System.out.println("hello ...");
		}
		else {
			System.out.println("call me!");
		}
		
		scanner.close();
		
	}


}