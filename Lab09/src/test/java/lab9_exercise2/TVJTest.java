package lab9_exercise2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TVJTest {
	AbstractItem item = null;

	@Test
	public void lab9_testConstruction() {
		item = new TV(2110.59, 50);
		assertEquals("TV (50\")", item.getName());
		assertEquals(2110.59, item.getPrice(),0);
	}
	
	@Test
	public void lab9_testGetSize() {
		TV tv = new TV(1599.50, 50);
		assertEquals(50, tv.getSize());
	}
	
	@Test
	public void lab9_testCalculateSalePrice() {
		item = new TV(150.50, 15);
		assertEquals("TV (15\")", item.getName());
		assertEquals(120.4, item.calculateSalePrice(),0);
	}
	

	@Test
	public void lab9_testConstruction2() {
		item = new TV(2150.50, 55);
		assertEquals("TV (55\")", item.getName());
		assertEquals(2150.50, item.getPrice(),0);
	}
	
	@Test
	public void lab9_testGetSize2() {
		TV tv = new TV(1899.50, 50);
		assertEquals(50, tv.getSize());
	}
	
	@Test
	public void lab9_testCalculateSalePrice2() {
		item = new TV(999.00, 42);
		assertEquals("TV (42\")", item.getName());
		assertEquals(799.2, item.calculateSalePrice(),0);
	}
	
}
