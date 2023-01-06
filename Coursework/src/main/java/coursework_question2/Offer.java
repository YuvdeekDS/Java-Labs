package coursework_question2;

import java.text.DecimalFormat;

public class Offer {

	private double value;
	private User buyer;
    DecimalFormat df=new DecimalFormat("#.00");

	public Offer(User buyer, double offerValue) {
		if (buyer == null || offerValue < 0) {
			throw new IllegalArgumentException();
		} else {
			this.buyer = buyer;
			this.value = offerValue;
		}
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return the buyer
	 */
	public User getBuyer() {
		return buyer;
	}

	@Override
	public String toString() {
		return buyer.toString() + " offered £" + df.format(value);
	}

}
