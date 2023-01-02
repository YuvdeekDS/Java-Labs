package lab9_exercise3;

import lab9_exercise3.Shop;

import java.util.HashMap;
import java.util.Map;

public class Mall {

	private Map<Integer, Shop> shops = null;

	public Mall() {
		shops = new HashMap<Integer,Shop>();
	}

	public void addShop(int number, Shop shop)  {
		if(shop ==null)
			throw new NullPointerException();
		if (number < 0)
			throw new IllegalArgumentException();
		if (this.shops.containsKey(number))
			throw new IllegalArgumentException();
		
		this.shops.put(number, shop);
	}

	public String displayAllShops() {
		StringBuffer output = new StringBuffer();
		for (var shop : this.shops.entrySet()) {
			output.append(shop.getKey() +" : " + shop.getValue().displayCatalogue() );
		}
		return output.toString();
	}

}
