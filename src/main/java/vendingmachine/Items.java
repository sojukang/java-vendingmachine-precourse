package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private static final String ERROR_ALREADY_IN_STOCK = "[ERROR] 이미 해당 상품이 존재합니다.";
	private List<Item> items = new ArrayList<>();

	public void addItem(Item newItem) {
		if (hasItem(newItem)) {
			throw new IllegalArgumentException(ERROR_ALREADY_IN_STOCK);
		}
		items.add(newItem);
	}

	private boolean hasItem(Item newItem) {
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
}
