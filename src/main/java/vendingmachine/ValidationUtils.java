package vendingmachine;

import static com.sun.javafx.font.FontResource.*;

public class ValidationUtils {
	private static final int UNIT_NO = 10;
	private static final int ZERO_NO = 0;

	public static void validNoFormat(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_INT);
		}
	}

	public static void validUnitNo(int input) {
		if (input % UNIT_NO != ZERO_NO) {
			throw new IllegalArgumentException(Messages.ERROR_INVALID_UNIT_NO);
		}
	}
}
