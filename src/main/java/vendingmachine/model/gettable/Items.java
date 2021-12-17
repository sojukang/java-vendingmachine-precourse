package vendingmachine.model.gettable;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.view.Messages;
import vendingmachine.view.Parser;
import vendingmachine.ValidationUtils;

public class Items implements Gettable {
	private final Map<String, Item> items;

	public Items(String userInputItems) {
		this.items = new HashMap<>();
		String[] itemsToAdd = Parser.splitBySemicolon(userInputItems);
		for (String newItem : itemsToAdd) {
			this.items.put(Parser.parseName(newItem), new Item(newItem));
		}
	}

	public Items() {
		items = null;
	}

	public void buyItem(String itemName, UserMoney userMoney) {
		if (hasItem(itemName)) {
			this.items.get(itemName).buy(userMoney);
		}
	}

	private boolean hasItem(String itemName) {
		if (!this.items.containsKey(itemName)) {
			throw new IllegalArgumentException(Messages.Error.NOT_IN_STOCK);
		}
		return true;
	}

	public boolean isAllOutOfStock() {
		for (Item item : this.items.values()) {
			 if (item.hasStock()) {
				 return false;
			}
		}
		return true;
	}

	public int minPrice() {
		int minPrice = Integer.MAX_VALUE;
		for (Item item : this.items.values()) {

			minPrice = item.compareMinPrice(minPrice);
		}
		return minPrice;
	}

	@Override
	public void check(String input) {
		ValidationUtils.isBlank(input);
		String[] itemsToAdd = Parser.splitBySemicolon(input);
		for (String itemString : itemsToAdd) {
			Item.validItemStatus(itemString);
		}
	}
}