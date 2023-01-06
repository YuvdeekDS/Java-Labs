package coursework_question1;

import java.text.DecimalFormat;

public class Car {

	private int id, numberOfSeats;
	private String name, colour;
	private double reservedPrice;
	private final Condition condition;
	private CarType gearbox;
	private CarBody body;
	DecimalFormat df = new DecimalFormat("#.00");

	public Car(int id, String carName, int price, Condition condition) {
		
		// throw argument exception error for invalid id, carName and price
		if (id < 0 || carName == null || price < 0){
			throw new IllegalArgumentException();
		}else {
			this.id = id;
			this.name = carName;
			this.reservedPrice = price;
			this.condition = condition;
		}
	}

	/**
	 * @return the numberOfSeats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	/**
	 * @param numberOfSeats the numberOfSeats to set
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	/**
	 * @return the gearbox
	 */
	public CarType getGearbox() {
		return gearbox;
	}

	/**
	 * @param gearBox the gearbox to set
	 */
	public void setGearbox(CarType gearbox) {
		this.gearbox = gearbox;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(CarBody body) {
		this.body = body;
	}

	/**
	 * @return the color
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return reservedPrice;
	}

	/**
	 * @return the body
	 */
	public CarBody getBodyStyle() {
		return body;
	}

	@Override
	public String toString() {
		return id + " - " + name;
	}

	public String outputBuilder() {
		StringBuilder builder = new StringBuilder();
		builder.append(id + " - ");
		builder.append(name);
		builder.append(" (£");
		builder.append(df.format(reservedPrice) + ")\n");
		builder.append("\tType: ");
		builder.append(gearbox + "\n");
		builder.append("\tStyle: ");
		builder.append(body + "\n");
		builder.append("\tColour: ");
		builder.append(colour + "\n");
		builder.append("\tNo. of Seats: ");
		builder.append(numberOfSeats + "\n");
		builder.append("\tCondition: ");
		builder.append(condition);
		return builder.toString();
	}

	public String displayCarSpecification() {
		return outputBuilder();
	}
}
