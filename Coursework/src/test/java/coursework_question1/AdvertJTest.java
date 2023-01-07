package coursework_question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import  org.junit.Test;

public class AdvertJTest {

	Advert advert = null;
	
	@Test(expected = IllegalArgumentException.class)
	public void coursework_testAdvert() {
		advert = new Advert(null);
	}
	
	@Test
	public void  coursework_testAdvertAddOffer() {
		User user = new User("Sid James");
	    Car car = new Car(1234, "Mazda 3", 20000, Condition.NEW);
		advert = new Advert(car);
		assertTrue(advert.placeOffer(user, 32000));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void coursework_testAdverOffernull() {
		Car car = new Car(1234, "Toyota", 20000, Condition.NEW);
		advert = new Advert(car);
		advert.placeOffer(null, 25000);
	}
	
	@Test
	public void coursework_testAdvertGethighestOffer() {
		User user = new User("Sid James");
		User user2 = new User("Bob Ross");
		Car car = new Car(1234, "Toyota", 20000, Condition.NEW);
		Advert advert  = new Advert(car);
		
		
		advert.placeOffer(user, 12000);
		advert.placeOffer(user2, 13000);
		advert.placeOffer(user, 22000);
		advert.placeOffer(user2, 16000);
		
		Offer testOffer = new Offer(user,22000);
		
		assertEquals(advert.getHighestOffer().toString(),testOffer.toString());
	}

}
