import java.util.ArrayList;

/**
 * A class for calculating discounts on grocery items.
 * 
 * This code already works BUT there is significant duplication between
 * calculateFixedDiscount and calculatePercentageDiscount.
 * 
 * Here's what to do:
 * 
 * 1.  Figure out a design that eliminates the duplication.  Use interfaces to do it.
 * Draw a (small, quick) UML diagram of the relevant parts
 * Get an instructor to sign off on your design before your proceed.
 * 2.  Implement the solution you've decided on, keeping the functionality the same
 * 3.  Modify the functionality so all discounts are listed on seperate lines after the item.
 * For example:
 * SPAM           $5.00   
 * DISCOUNT 10%  -$0.50
 * 4.  Add a new discount that is a "Buy X get Y free" where just buying one thing doesn't
 * give a discount, but then subsequent buys can become free if you buy enough
 * 
 * @author hewner
 *
 */
public class DiscountInterfacesMain {

	/**
	 * @param args command line args ignored
	 */
	public static void main(String[] args) {
		ArrayList<GroceryItem> items = new ArrayList<GroceryItem>();
		
		// in a slightly fancier program, we might get this list from
		// user input or something.  But for now it's a good start.
		items.add(new GroceryItem("Milk", 3.00));
		items.add(new GroceryItem("Cheese", 3.50));
		items.add(new GroceryItem("Eggs 1 dozen", 1.00));
		items.add(new GroceryItem("Pepsi 2 liter", 0.99));
		items.add(new GroceryItem("Bread", 0.99));
		items.add(new GroceryItem("SPAM", 5.00));
		
		double subtotal = 0;
		for(GroceryItem item : items) {
			System.out.println(item.receptString());
			subtotal += item.cost();
		}
		
		double basicDiscount = calculateFixedDiscount(items);
		double percentageDiscount = calculatePercentageDiscount(items);
		double total = subtotal - basicDiscount - percentageDiscount;
		
		System.out.println("Subtotal             $" + subtotal);
		System.out.println("Discounts           -$" + (basicDiscount + percentageDiscount));
		System.out.println("Total                $" + total);

	}

	/**
	 * Returns discount for items that have a fixed discount (e.g. 20 cents off)
	 * 
	 * Items are matched based on name so a discount named "Egg" will match
	 * any item that contains the words Egg (e.g. "1 dozen Eggs" or "Eggo Waffles") 
	 * 
	 * @param items the item list to check for possible discounts
	 * @return the total savings for all items
	 */
	public static double calculateFixedDiscount(ArrayList<GroceryItem> items) {
		String[] discountNames = {"Milk","Bread","Coke"};
		double[] discountAmount = {1.00,0.25,0.5};
		double overallDiscount = 0;
		for(GroceryItem item : items) {
			for(int i = 0; i < discountNames.length; i++) {
				if(item.getName().contains(discountNames[i])) {
					overallDiscount += discountAmount[i];
				}
			}
		}
		return overallDiscount;
	}
	
	/**
	 * Returns discount for items that have a percentage discount (e.g. 20% off)
	 * 
	 * Items are matched based on name so a discount named "Egg" will match
	 * any item that contains the words eggs (e.g. "1 dozen Eggs" or "Eggo Waffles") 
	 * 
	 * Percentages are represented bewteen zero and 1 (i.e. a 20% discount is 0.2)
	 * 
	 * @param items the item list to check for possible discounts
	 * @return the total savings for all items
	 */
	public static double calculatePercentageDiscount(ArrayList<GroceryItem> items) {
		String[] discountNames = {"Eggs","SPAM"};
		double[] discountPercentage = {0.05,0.1};
		double overallDiscount = 0;
		for(GroceryItem item : items) {
			for(int i = 0; i < discountNames.length; i++) {
				if(item.getName().contains(discountNames[i])) {
					overallDiscount += discountPercentage[i]*item.cost();
				}
			}
		}
		return overallDiscount;
	}
	
}
