package coursework_question4;

public class Seller extends User{

	private int sales;
	/**
	 * @return the sales
	 */
	public int getSales() {
		return sales;
	}

	/**
	 * @param sales the sales to set
	 */
	public void setSales(int sales) {
		this.sales = sales;
	}

	public Seller(String name) {
		super(name);
	}

	public String identifyRating() {
		String rating="Level ";
		if(sales == 0) {
			rating+="0";
		}else if(sales <= 5) {
			rating += "1";
		}else if (sales >= 6 && sales <= 10){
			rating+="2";
		} else if(sales > 10) {
			rating+="3";
		}
		return rating;
	}

	@Override
	public String toString() {
		String sellername = super.toString();
		sellername = sellername.split(" ")[0]+" "+sellername.split(" ")[1].charAt(0) + ". (Sales: "+sales+", Rating: "+identifyRating()+")";
		return sellername;
	}
}
