package lab9_abstract;

public class Check {

	public static void main(String[] args) {
		IItem item1 = new MP3Player(250);
		IItem item2 = new MP3Player(150);

		StringBuffer output = new StringBuffer(); // create a StringBuffer object, which the output will be appended to
		output.append("Shop Catalogue\n\nItem\t\tPrice\tSale Price\n");
		output.append(item1.getName() + "\t£" + String.format("%.2f", item1.getPrice()) + "	£"
				+ String.format("%.2f", item1.calculateSalePrice()) + "\n");
		output.append(item2.getName() + "\t£" + String.format("%.2f", item2.getPrice()) + "	£"
				+ String.format("%.2f", item2.calculateSalePrice()) + "\n");

		System.out.println(output.toString());
	}
}
