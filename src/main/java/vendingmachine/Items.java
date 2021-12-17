package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private final List<Item> item;

	public Items(String userInputItems) {
		this.item = new ArrayList<>();
		String[] itemsToAdd = Parser.splitBySemicolon(userInputItems);
		for (String newItem : itemsToAdd) {
			this.item.add(new Item(newItem));
		}
	}
}