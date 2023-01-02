package lab9_exercise3;

public class TV extends AbstractItem{
	private static final double SALE_PERCENTAGE = 0.80;
	private int size = 0;
	public TV(double price,int size) {
		super(price);
		this.size = size;
	}

	@Override
	public double calculateSalePrice() {
		return this.getPrice() * SALE_PERCENTAGE;
	}

	@Override
	public String getName() {
		return "TV ("+this.size+"\")";
	}

	@Override
	public double getPrice() {
		
		return super.getPrice();
	}

	@Override
	public void setPrice(double price) {
		
		super.setPrice(price);
	}
	
	public int getSize() {
		return this.size;
	}
	
	
}
