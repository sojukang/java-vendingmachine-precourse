package vendingmachine;

public class ValidationUtils {

	private static final String ERROR_NOT_MATCH_UNIT_MONEY = "[ERROR] 금액은 10원 단위여야 합니다.";
	private static final String ERROR_NOT_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String ERROR_NOT_POSITIVE = "[ERROR] 0 이상의 숫자여야 합니다.";

	public static void validUnitMoney(int money) {
		if (money % 10 != 0) {
			throw new IllegalArgumentException(ERROR_NOT_MATCH_UNIT_MONEY);
		}
	}

	public static void validNumberFormat(String num) {
		try {
			 Integer.parseInt(num);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER);
		}
	}

	public static void isPositive(int num) {
		if (num <= 0 ) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
		}
	}

	public static void main(String[] args) {
		validNumberFormat("a1");
	}
}
