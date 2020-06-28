import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
	

	public static void main(String[] args) throws Exception {
		
		File file = new File("/home/borisjokic/eclipse-workspace/MyJava/src/myFile.txt");
		Scanner scanner = new Scanner(file);
		List<Integer> num = new ArrayList<Integer>();
		
		while(scanner.hasNextLine()) {
			int element = scanner.nextInt();
			System.out.println(element);
			num.add(element);
		}
		
		scanner.close();
		System.out.println(Arrays.toString(num.toArray()));
	}


}