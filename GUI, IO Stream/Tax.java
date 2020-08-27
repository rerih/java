
public class Tax {
	
	double grossIncome;
	String state;
	int dependents;
	static int cosumerCounter;
	
	public Tax(double grossIncome, String state, int dependents) {
		this.grossIncome = grossIncome;
		this.state = state;
		this.dependents = dependents;
		cosumerCounter++;
		System.out.println(cosumerCounter);
	}
	public double calcTax() {
		double stateTax = 0;
		if (grossIncome < 30_000) {
			int taxCredit = 300;
			stateTax = grossIncome * 0.05 - taxCredit;
		}
		else {
			stateTax = grossIncome * 0.06;
		}
		return stateTax;
 	}
}
