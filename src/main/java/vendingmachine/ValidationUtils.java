package vendingmachine;

public class ValidationUtils {
	public static void validNoFormat(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_INT);
		}
	}
}
