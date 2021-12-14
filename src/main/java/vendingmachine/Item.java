package vendingmachine;

import static vendingmachine.ValidationUtils.*;

import java.util.Objects;

public class Item {

	private final String name;
	private final int price;
	private int count;

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

	public boolean sameName(Item newItem) {
		return this.equals(newItem);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Item item = (Item)o;
		return Objects.equals(name, item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public void sell(UserMoney userMoney) {
		subCount();
		userMoney.buy(price);
	}

	private void subCount() {
		count--;
	}

	public int compareMinPrice(int minPrice) {
		return Math.min(price, minPrice);
	}

	public boolean isOutOfStock() {
		return count == 0;
	}
}
