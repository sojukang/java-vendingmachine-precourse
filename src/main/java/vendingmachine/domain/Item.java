package vendingmachine.domain;

import static vendingmachine.ValidationUtils.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vendingmachine.view.Messages;

public class Item {

	private static final int INDEX_NAME = 0;
	private static final int INDEX_PRICE = 1;
	private static final int INDEX_COUNT = 2;
	private final String name;
	private final int price;
	private int count;

	public Item(String InputItemStatus) {
		List<String> itemStatus = validItemStatus(InputItemStatus);
		this.name = itemStatus.get(INDEX_NAME);
		this.price = Integer.parseInt(itemStatus.get(INDEX_PRICE));
		this.count = Integer.parseInt(itemStatus.get(INDEX_COUNT));
	}

	public static void validName(String name) {
		isBlank(name);
	}

	public static void validPrice(String price) {
		isBlank(price);
		int itemPrice = validNumberFormat(price);
		validUnitMoney(itemPrice);
		isPositive(itemPrice);
	}

	public static void validCount(String count) {
		isBlank(count);
		int itemCount = validNumberFormat(count);
		isPositive(itemCount);
	}
	private static String removeBracket(String itemString) {
		return itemString.substring(1, itemString.length() - 1);
	}

	private static String[] splitByComma(String itemString) {
		return itemString.split(",");
	}

	private static List<String> trimItemStatus(String[] itemStatus) {
		return Stream.of(itemStatus).map(item -> item.trim()).collect(Collectors.toList());
	}

	public static List<String> validItemStatus(String itemString) {
		validItemStatusFormat(itemString);
		List<String> itemStatus = trimItemStatus(splitByComma(removeBracket(itemString)));
		validName(itemStatus.get(INDEX_NAME));
		validPrice(itemStatus.get(INDEX_PRICE));
		validCount(itemStatus.get(INDEX_COUNT));
		return itemStatus;
	}

	private static void validItemStatusFormat(String itemString) {
		if (itemString.charAt(0) != '[' || itemString.charAt(itemString.length() - 1) != ']') {
			throw new IllegalArgumentException(Messages.ERROR_WRONG_INPUT);
		}
	}

	public boolean hasStock(String itemName) {
		return name.equals(itemName) && this.count > 0;
	}

	public boolean sameName(Item newItem) {
		return this.equals(newItem);
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

	public void sell(UserMoney userMoney) {
		subCount();
		userMoney.buy(price);
	}

	private void subCount() {
		this.count--;
	}

	public int compareMinPrice(int minPrice) {
		return Math.min(price, minPrice);
	}

	public boolean isOutOfStock() {
		return this.count == 0;
	}
}
