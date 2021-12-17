package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Items {
	private final Map<String, Item> items;

	public Items(String userInputItems) {
		this.items = new HashMap<>();
		String[] itemsToAdd = Parser.splitBySemicolon(userInputItems);
		for (String newItem : itemsToAdd) {
			this.items.put(Parser.parseName(newItem), new Item(newItem));
		}
	}

	public void buyItem(String itemName, UserMoney userMoney) {
		if (hasItem(itemName)) {
			this.items.get(itemName).buy(userMoney);
		}
	}

	private boolean hasItem(String itemName) {
		if (!this.items.containsKey(itemName)) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_IN_STOCK);
		}
		return true;
	}
}