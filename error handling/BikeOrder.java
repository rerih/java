
public class BikeOrder {
	
	private String order = "";
	
	public String getOrder() {
		return order;
	}
	
	public void validateOrder(String bikeModel, int quantity) throws TooManyBikesException {
		
	 if ((bikeModel.equals("mountain bike") && quantity < 7) || (bikeModel.equals("road bike") && quantity < 16) || (bikeModel.equals("fitness bike") && quantity < 9)) {
			order = "The order is placed. Model: " + bikeModel + "  " + quantity;
		}
		else {
			order = "You cannot order " + bikeModel + " in quantity: " + quantity;
			throw new TooManyBikesException("Too many bikes" + quantity);
		}
	}

}
