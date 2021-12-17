package vendingmachine;

import static vendingmachine.ValidationUtils.*;

import java.util.List;
import java.util.Objects;

public class Item {
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
			throw new IllegalArgumentException(Messages.ERROR_INVALID_ITEM);
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

	private void checkStock() {
		if (count <= 0) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_IN_STOCK);
		}
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

	public boolean hasStock() {
		return this.count > 0;
	}

	public int compareMinPrice(int minPrice) {
		return Math.min(this.price, minPrice);
	}
}
