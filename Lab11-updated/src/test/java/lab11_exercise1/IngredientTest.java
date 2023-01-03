package lab11_exercise1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IngredientTest {

	@Test
	public void testGetCookedWeight() {
		Supplier supplier = new Supplier("Bloggs", "01483681234");
		Ingredient ingredient = new Ingredient("Chicken", IngredientType.MEAT, supplier, 100, 110, 1.2, 0.6);

		assertEquals(100 * 0.8, ingredient.getCookedWeight(), 0);
	}

	@Test
	public void testIngredient() {
		Supplier supplier = new Supplier("Bloggs", "01483681234");
		Ingredient ingredient = new Ingredient("Coconut Cream", IngredientType.VEGETABLE, supplier, 250, 824, 86.7, 10);

		assertEquals("Coconut Cream", ingredient.getName());
		assertEquals(IngredientType.VEGETABLE, ingredient.getType());
		assertEquals(supplier, ingredient.getSupplier());
		assertEquals(250, ingredient.getRawWeight(), 0);
		assertEquals(824, ingredient.getCalories(), 0);
		assertEquals(86.7, ingredient.getFat(), 0);
		assertEquals(10, ingredient.getSodium(), 0);
	}

	@Test
	public void testGetCookedWeightVeg() {
		Supplier supplier = new Supplier("Bobby", "08001111");
		Ingredient ingredient = new Ingredient("Asparagus", IngredientType.VEGETABLE, supplier, 134, 27, 0.1, 2.7);

		assertEquals(107.2, ingredient.getCookedWeight(), 0);
	}

	@Test
	public void testIngredientMeat() {
		Supplier supplier = new Supplier("Bobby", "08001111");
		Ingredient ingredient = new Ingredient("Lamb Chop", IngredientType.MEAT, supplier, 242, 712, 51, 174.2);

		assertEquals("Lamb Chop", ingredient.getName());
		assertEquals(IngredientType.MEAT, ingredient.getType());
		assertEquals(supplier, ingredient.getSupplier());
		assertEquals(242, ingredient.getRawWeight(), 0);
		assertEquals(712, ingredient.getCalories(), 0);
		assertEquals(51, ingredient.getFat(), 0);
		assertEquals(174.2, ingredient.getSodium(), 0);
	}

	@Test
	public void testIngredientCookedMeat() {
		Supplier supplier = new Supplier("Bobby", "08001111");
		Ingredient ingredient = new Ingredient("Lamb Chop", IngredientType.MEAT, supplier, 260, 712, 51, 174.2);

		assertEquals(208, ingredient.getCookedWeight(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidSupplierSpace() {
		Supplier supplier = new Supplier("James", "01234 5678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidSupplierLength() {
		Supplier supplier = new Supplier("Hannah", "012345678900");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidSupplierFormat() {
		Supplier supplier = new Supplier("Eve", "1234567890");
	}

}
