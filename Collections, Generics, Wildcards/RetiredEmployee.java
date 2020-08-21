
public class RetiredEmployee extends Employee {

	private int pensionAmount;
	
	public RetiredEmployee(String name, int pensionAmount) {
		super(name);
		this.pensionAmount = pensionAmount;
	}


	public int getPensionAmount() {
		return pensionAmount;
	}


	public void setPensionAmount(int pensionAmount) {
		this.pensionAmount = pensionAmount;
	}
	
}
