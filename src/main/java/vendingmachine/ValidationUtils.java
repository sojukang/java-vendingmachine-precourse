package vendingmachine;

import vendingmachine.domain.Item;
import vendingmachine.view.Messages;

public class ValidationUtils {

	public static void validUnitMoney(int money) {
		if (money % 10 != 0) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_MATCH_UNIT_MONEY);
		}
	}

	public static int validNumberFormat(String num) {
		try {
			return Integer.parseInt(num);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_NUMBER);
		}
	}

	public static void isPositive(int num) {
		if (num <= 0) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_POSITIVE);
		}
	}

	public static void isBlank(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(Messages.ERROR_IS_BLANK);
		}
	}

	public static String[] validItemsInput(String input) {
		try {
			String[] validInput = input.split(";");
			for (String itemString : validInput) {
				Item.validItemStatus(itemString);
			}
			return validInput;
		} catch (Exception e) {
			throw new IllegalArgumentException(Messages.ERROR_WRONG_INPUT);
		}
	}
}
