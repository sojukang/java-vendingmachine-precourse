package vendingmachine;

public class ValidationUtils {
	private static final int UNIT_NO = 10;
	private static final int ZERO_NO = 0;
	private static final int MIN_REMAINS = 0;
	private static final int MIN_USER_MONEY = 100;

	public static int validNoFormat(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_INT);
		}
	}

	public static void validUnitNo(int input) {
		if (input % UNIT_NO != ZERO_NO) {
			throw new IllegalArgumentException(Messages.ERROR_INVALID_UNIT_NO);
		}
	}

	private static void moneyGreaterThanMin(int min, int money) {
		if (money < min) {
			throw new IllegalArgumentException(Messages.ERROR_SMALLER_THAN_MIN);
		}
	}

	public static void moneyGreaterThanRemainsMin(int remains) {
		moneyGreaterThanMin(MIN_REMAINS, remains);
	}

	public static void moneyGreaterThanUserMoneyMin(int userMoney) {
		moneyGreaterThanMin(MIN_USER_MONEY, userMoney);
	}

	public static void isBlank(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(Messages.ERROR_BLANK);
		}
	}

	public static void isPositive(int input) {
		if (input <= 0 ) {
			throw new IllegalArgumentException(Messages.ERROR_GREATER_THAN_ZERO);
		}
	}

	public static int validMoneyInput(String input) {
		int money = validNoFormat(input);
		moneyGreaterThanRemainsMin(money);
		validUnitNo(money);
		return money;
	}
}
