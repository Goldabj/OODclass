
public class PercentageDiscount implements DiscountInterface {
	String item;
	double discount;
	
	public PercentageDiscount(String item, double discount) {
		this.item = item;
		this.discount = discount;
	}
	
	@Override
	public double getDiscount() {
		return this.discount;
	}

}
