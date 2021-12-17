package vendingmachine;

import static vendingmachine.ValidationUtils.*;

import java.util.List;

public class Item {
	private static final int INDEX_NAME = 0;
	private static final int INDEX_PRICE = 1;
	private static final int INDEX_COUNT = 2;
	private final String name;
	private final int price;
	private final int count;

	public Item(String input) {
		List<String> itemStatus = validItemStatus(input);
		this.name = itemStatus.get(INDEX_NAME);
		this.price = Integer.parseInt(itemStatus.get(INDEX_PRICE));
		this.count = Integer.parseInt(itemStatus.get(INDEX_COUNT));
	}

	private static void validName(String name) {
		isBlank(name);
	}

	private static void validPrice(String priceStr) {
		int price = validNoFormat(priceStr);
		validUnitNo(price);
	}

	private static void validCount(String countStr) {
		int count = validNoFormat(countStr);
		isPositive(count);
	}

	public List<String> validItemStatus(String input) {
		List<String> itemStatus = Parser.parseItemStatus(input);
		validName(itemStatus.get(INDEX_NAME));
		validPrice(itemStatus.get(INDEX_PRICE));
		validCount(itemStatus.get(INDEX_COUNT));
		return itemStatus;
	}
}
