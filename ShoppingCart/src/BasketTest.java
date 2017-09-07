import org.junit.Assert;
import org.junit.Test;


public class BasketTest {
	
	@Test
	public void testCreateEmptyShoppingBasket() {
		Basket cart = new Basket();
		Assert.assertEquals(0, cart.getItemCount());
	}
	
	@Test
	public void testAddSingleFruitToBasket() {
		Basket cart = new Basket();
		Item itm = new Item("Bananas",50.0, 2);
		cart.addItem(itm);
		Assert.assertEquals(1, cart.getItemCount());
		Assert.assertEquals(100.0, cart.getPriceofFruit(itm),0.0);
		cart.removeItem(itm);
	}
	
	@Test
	public void addDifferentFruitsToTheBasket(){
		Basket cart = new Basket();
		Item itm1 = new Item("Bananas",50.0, 2);
		Item itm2 = new Item("Oranges",70.0, 3);

		cart.addItem(itm1);
		cart.addItem(itm2);
		
		Assert.assertEquals(2, cart.getItemCount());
		Assert.assertEquals(310.0, cart.getTotalBasketValue(),0.0);
		cart.removeItem(itm1);
		cart.removeItem(itm2);
		
	}
	
	@Test
	public void testRemoveSingleFruitFromBasket() {
		Basket cart = new Basket();
		Item itm = new Item("Bananas",50.0, 2);
		cart.addItem(itm);
		Assert.assertEquals(1, cart.getItemCount());
		cart.removeItem(itm);
		Assert.assertEquals(0, cart.getItemCount());
	}

}
