package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private List<Item> items = new ArrayList<>();

	public void addItem(Item newItem) {
		items.add(newItem);
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
