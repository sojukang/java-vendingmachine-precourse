package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private static final String ERROR_ALREADY_IN_STOCK = "[ERROR] 이미 해당 상품이 존재합니다.";
	private List<Item> items = new ArrayList<>();

	public void addItem(Item newItem) {
		if (isAlreadyInStock(newItem)) {
			throw new IllegalArgumentException(ERROR_ALREADY_IN_STOCK);
		}
		items.add(newItem);
	}

	private boolean isAlreadyInStock(Item newItem) {
		for (Item item : items) {
			if (item.sameName(newItem)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasItem(String itemName) {
		for (Item item : items) {
			if (item.hasStock(itemName)) {
				return true;
			}
		}
		return false;
	}

	public void sellItem(String itemName, UserMoney userMoney) {
		for (Item item : items) {
			if (item.hasStock(itemName)) {
				item.sell(userMoney);
			}
		}
	}

	public int minPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Item item : items) {
			minPrice = item.compareMinPrice(minPrice);
		}
		return minPrice;
	}

	public boolean allOutOfStock() {
		for (Item item : items) {
			if (!item.isOutOfStock()) {
				return false;
			}
		}
		return true;
	}
}
