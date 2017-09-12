import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Basket {

	// *** declare and instantiate a variable cart to be an empty ArrayList
	static ArrayList<Item> Cart = new ArrayList<Item>();
	static double totalPrice = 0.0;
	static double price = 0.0;

	public static void main(String[] args)

	{

		Item item;

		String itemName;

		double itemPrice;

		int quantity;

		Scanner scan = new Scanner(System.in);

		String keepShopping = "y";

		do

		{

			System.out.print("Enter the name of the fruit to be added in basket: ");

			itemName = scan.nextLine();

			System.out.print("Enter the price per kg of fruit: ");

			itemPrice = scan.nextDouble();

			System.out.print("Enter the quantity: ");

			quantity = scan.nextInt();

			// *** create a new item and add it to the cart

			item = new Item(itemName, itemPrice, quantity);

			price = getPriceofFruit(item);

			NumberFormat format = NumberFormat.getCurrencyInstance();

			System.out.println("The price is: " + format.format(price));

			addItem(item);

			// *** print the contents of the cart object using println

			System.out.print("Continue shopping (y/n)? ");

			scan.nextLine();

			keepShopping = scan.nextLine();

		} while (keepShopping.equals("y"));

		totalPrice = getTotalBasketValue();
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		System.out.println("The total price  of all fruits in basket is: " + fmt.format(totalPrice));

	}

	public int getItemCount() {
		return Cart.size();
	}

	public static void addItem(Item itm) {
		Cart.add(itm);

	}

	public static void removeItem(Item itm) {
		Cart.remove(itm);

	}

	public static double getPriceofFruit(Item itm) {

		price = (itm.getPrice()) * (itm.getQuantity());
		return price;
	}

	public static double getTotalBasketValue() {
		if (Cart.size() > 0) {
			for (Item itm : Cart) {
				System.out.println(itm);

				totalPrice = totalPrice + (itm.getPrice() * itm.getQuantity());

			}
		}
		return totalPrice;
	}

}
