package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

	public static int getRemains() {
		return repeatInput(Messages.GET_REMAINS);
	}

	public static int getUserInput(String message) {
		System.out.println(message);
		return ValidationUtils.validMoneyInput(readLine());
	}

	private static int repeatInput(String message) {
		while (true) {
			try {
				return getUserInput(message);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
