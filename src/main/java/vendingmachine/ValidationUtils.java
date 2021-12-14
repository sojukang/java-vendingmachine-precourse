package vendingmachine;

public class ValidationUtils {

	private static final String ERROR_NOT_MATCH_UNIT_MONEY = "[ERROR] 금액은 10원 단위여야 합니다.";

	public static void validUnitMoney(int money) {
		if (money % 10 != 0) {
			throw new IllegalArgumentException(ERROR_NOT_MATCH_UNIT_MONEY);
		}
	}

	public static int validNumberFormat(String num) {
		return Integer.parseInt(num);
	}
}
