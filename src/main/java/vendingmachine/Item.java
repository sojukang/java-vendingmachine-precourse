package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class Item {

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

	public static void validItemStatus(String itemString) {
		String[] itemStatus = itemString.substring(1, itemString.length() - 1).split(",");
		validName(itemStatus[0]);
		validPrice(itemStatus[1]);
		validCount(itemStatus[2]);
	}
}
