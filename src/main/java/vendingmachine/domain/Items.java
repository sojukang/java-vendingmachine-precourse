package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.view.Messages;

public class Items {
	private List<Item> items = new ArrayList<>();

	public void addItem(Item newItem) {
		if (isAlreadyInStock(newItem)) {
			throw new IllegalArgumentException(Messages.ERROR_ALREADY_IN_STOCK);
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

	public void addItems(String[] itemToAdd) {
		for (String itemStatus : itemToAdd) {
			addItem(new Item(itemStatus));
		}
	}
}
