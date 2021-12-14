package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class Item {

	private final String name;
	private final int price;
	private final int count;

	public Item(String InputItemStatus) {
		String[] itemStatus =  validItemStatus(InputItemStatus);
		this.name = itemStatus[0];
		this.price = Integer.parseInt(itemStatus[1]);
		this.count = Integer.parseInt(itemStatus[2]);
	}

	public static void validName(String name) {
		isBlank(name);
	}

	public static void validPrice(String price) {
		isBlank(price);
		int itemPrice = validNumberFormat(price);
		validUnitMoney(itemPrice);
		isPositive(itemPrice);
	}

	public static void validCount(String count) {
		isBlank(count);
		int itemCount = validNumberFormat(count);
		isPositive(itemCount);
	}

	public static String[] validItemStatus(String itemString) {
		String[] itemStatus = itemString.substring(1, itemString.length() - 1).split(",");
		validName(itemStatus[0]);
		validPrice(itemStatus[1]);
		validCount(itemStatus[2]);
		return itemStatus;
	}

	public boolean hasStock(String itemName) {
		return name.equals(itemName) && count > 0;
	}
}
