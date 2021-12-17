package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

	public static int getRemains() {
		return Integer.parseInt(repeatInput(Messages.GET_REMAINS, new Remains()));
	}

	public static String getUserInput(String message, Gettable gettable) {
		System.out.println(message);
		String input = readLine();
		gettable.check(input);
		return input;
	}

	private static String repeatInput(String message, Gettable gettable) {
		while (true) {
			try {
				return getUserInput(message, gettable);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static String getUserMoney() {
		return repeatInput(Messages.GET_USER_MONEY, new UserMoney());
	}


}
