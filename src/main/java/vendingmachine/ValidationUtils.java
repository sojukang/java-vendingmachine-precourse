package vendingmachine;

import vendingmachine.domain.Item;

public class ValidationUtils {

	private static final String ERROR_NOT_MATCH_UNIT_MONEY = "[ERROR] 금액은 10원 단위여야 합니다.";
	private static final String ERROR_NOT_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String ERROR_NOT_POSITIVE = "[ERROR] 0 이상의 숫자여야 합니다.";
	private static final String ERROR_IS_BLANK = "[ERROR] 빈 문자열 입력입니다.";
	private static final String ERROR_WRONG_INPUT = "[ERROR] 잘못된 입력입니다.";

	public static void validUnitMoney(int money) {
		if (money % 10 != 0) {
			throw new IllegalArgumentException(ERROR_NOT_MATCH_UNIT_MONEY);
		}
	}

	public static int validNumberFormat(String num) {
		try {
			return Integer.parseInt(num);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER);
		}
	}

	public static void isPositive(int num) {
		if (num <= 0) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
		}
	}

	public static void isBlank(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(ERROR_IS_BLANK);
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
			throw new IllegalArgumentException(ERROR_WRONG_INPUT);
		}
	}
}
