
public class FixedDiscount implements DiscountInterface {
	String item;
	double discount;
	
	public FixedDiscount(String item, double discount) {
		this.item = item;
		this.discount = discount;
	}
	
	@Override
	public double getDiscount() {
		return this.discount;
	}

}
