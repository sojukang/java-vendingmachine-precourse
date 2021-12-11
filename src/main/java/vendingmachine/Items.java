package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private List<Item> itemList = new ArrayList<>();

	public void isAddable(String itemsInput) {
		String[] itemToAdd = itemsInput.substring(1, itemsInput.length() - 1).split(",");
		Item.validItemStatus(itemToAdd[0], Integer.parseInt(itemToAdd[1]), Integer.parseInt(itemToAdd[2]));
	}

	public Item hasItem(String itemName) {
		for (Item item : itemList) {
			if (item.sameName(itemName)) {
				return item;
			}
		}
		throw new IllegalArgumentException("[ERROR] 해당 상품이 없습니다.");
	}

	public void addItem(String itemString) {
		try {
			isAddable(itemString);
			itemList.add(new Item(itemString));
		} catch (Exception e) {}

	}

	public int minPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Item item : itemList) {
			minPrice = item.isMinPrice(minPrice);
		}
		return minPrice;
	}

	public boolean allOutOfStock() {
		for (Item item : itemList) {
			if (!item.isOutOfStock()) {
				return false;
			}
		}
		return true;
	}

}
