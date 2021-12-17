package vendingmachine.model.gettable;

import static vendingmachine.ValidationUtils.*;

import java.util.List;
import java.util.Objects;

import vendingmachine.model.Index;
import vendingmachine.view.Messages;
import vendingmachine.view.Parser;

public class Item implements Gettable {
	private static final int ALL_PROPERTIES = 3;
	private final String name;
	private final int price;
	private int count;

	public Item(String input) {
		List<String> itemStatus = validItemStatus(input);
		this.name = itemStatus.get(Index.NAME);
		this.price = Integer.parseInt(itemStatus.get(Index.PRICE));
		this.count = Integer.parseInt(itemStatus.get(Index.COUNT));
	}

	public Item() {
		name = null;
		price = 0;
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

	public static List<String> validItemStatus(String input) {
		List<String> itemStatus = Parser.parseItemStatus(input);
		GotAllProperties(itemStatus);
		validName(itemStatus.get(Index.NAME));
		validPrice(itemStatus.get(Index.PRICE));
		validCount(itemStatus.get(Index.COUNT));
		return itemStatus;
	}

	private static void GotAllProperties(List<String> itemStatus) {
		if (itemStatus.size() != ALL_PROPERTIES) {
			throw new IllegalArgumentException(Messages.Error.INVALID_ITEM);
		}
	}

	public void buy(UserMoney userMoney) {
		checkStock();
		subCount();
		userMoney.buy(this.price);
	}

	private void subCount() {
		this.count--;
	}

	public void checkStock() {
		if (!hasStock()) {
			throw new IllegalArgumentException(Messages.Error.NOT_IN_STOCK);
		}
	}

	public boolean hasStock() {
		return count > 0;
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

	public int compareMinPrice(int minPrice) {
		return Math.min(this.price, minPrice);
	}

	@Override
	public void check(String input) {
		isBlank(input);
	}
}
