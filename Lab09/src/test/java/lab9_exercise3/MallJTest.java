package lab9_exercise3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MallJTest {
	Mall friaryMall = null;

	@Test
	public void lab9_testConstruction() {
		friaryMall = new Mall();
		assertEquals("", friaryMall.displayAllShops());
	}

	@Test
	public void lab9_testAddemptyShop() {
		friaryMall = new Mall();
		Shop shop = new Shop();
		friaryMall.addShop(0, shop);
		assertEquals("0 : Shop Catalogue\n" + "\n" + "Item		Price	Sale Price\n" + "",
				friaryMall.displayAllShops());
	}

	@Test(expected = NullPointerException.class)
	public void lab9_testAddInvalidShop() {
		friaryMall = new Mall();
		friaryMall.addShop(0, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lab9_testAddInvalidNumber() {
		friaryMall = new Mall();
		Shop shop = new Shop();
		friaryMall.addShop(-10, shop);
	}

	@Test
	public void lab9_testAddValidShop() {
		friaryMall = new Mall();
		Shop shop = new Shop();
		shop.addItem(new TV(850.00, 42));
		friaryMall.addShop(1, shop);
		assertEquals(
				"1 : Shop Catalogue\n" + "\n" + "Item		Price	Sale Price\n" + "TV (42\")	£850.00	£680.00\n" + "",
				friaryMall.displayAllShops());
	}

	@Test
	public void lab9_testAddValidShop2() {
		friaryMall = new Mall();
		Shop shop = new Shop();
		shop.addItem(new TV(1200, 42));
		friaryMall.addShop(1, shop);
		assertEquals(
				"1 : Shop Catalogue\n" + "\n" + "Item		Price	Sale Price\n" + "TV (42\")	£1200.00	£960.00\n",
				friaryMall.displayAllShops());
	}

	private class DummyItem implements IItem {

		@Override
		public double calculateSalePrice() {
			return 120.4;
		}

		@Override
		public String getName() {
			return "TV (15\")";
		}

		@Override
		public double getPrice() {
			return 150.50;
		}

		@Override
		public void setPrice(double price) {

		}

	}

	private class DummyItem2 implements IItem {

		@Override
		public double calculateSalePrice() {
			return 112.5;
		}

		@Override
		public String getName() {
			return "MP3 Player";
		}

		@Override
		public double getPrice() {
			return 150.00;
		}

		@Override
		public void setPrice(double price) {

		}

	}

	@Test
	public void lab9_testAddComplexShop() {
		friaryMall = new Mall();
		Shop shop = new Shop();
		IItem item1 = new DummyItem();
		IItem item2 = new DummyItem2();
		shop.addItem(item1);
		shop.addItem(item2);
		friaryMall.addShop(5, shop);
		assertEquals("5 : Shop Catalogue\n" + "\n" + "Item		Price	Sale Price\n" + "TV (15\")	£150.50	£120.40\n"
				+ "MP3 Player	£150.00	£112.50\n" + "", friaryMall.displayAllShops());
	}
}
