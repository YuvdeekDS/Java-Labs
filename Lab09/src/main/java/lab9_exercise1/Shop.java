package lab9_exercise1;

import java.util.ArrayList;
import lab9_exercise1.IItem;

public class Shop {

	private ArrayList<IItem> items = null;

	public Shop() {
		this.items = new ArrayList<IItem>();
	}

	public void addItem(IItem item) {
		items.add(item);
	}

	public String displayCatalogue() {
		StringBuffer output = new StringBuffer(); // create a StringBuffer object, which the output will be appended to
		output.append("Shop Catalogue\n\nItem\t\tPrice\tSale Price\n");
		for (IItem item : items) {
			output.append(item.getName() + "\t£" + String.format("%.2f", item.getPrice()) + "	£"
					+ String.format("%.2f", item.calculateSalePrice()) + "\n");
		}
		return output.toString();
	}

	public static void main(String[] args) {

	}

}
