package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.ValidationUtils;
import vendingmachine.domain.UserMoney;
import vendingmachine.domain.VendingMachine;

public class InputView {

	public static void printGetItemToAdd() {
		System.out.println(Messages.GET_ITEM_TO_ADD);
	}

	public static String getItemToAdd() {
		return readLine();
	}

	public static int getUserMoney() {
		return repeatInput(Messages.GET_USER_MONEY);
	}

	public static int getUserInput(String getUserInputMessage) {
			System.out.println(getUserInputMessage);
			String userInput = readLine();
			return ValidationUtils.validMoneyInput(userInput);
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

	public static int getRemains() {
		return repeatInput(Messages.GET_REMAINS);
	}

	public static String getItemToBuy(VendingMachine machine) {
		System.out.println("\n투입 금액: " + machine.getRemainUserMoney() + "원");
		System.out.println(Messages.GET_ITEM_TO_BUY);
		return readLine();
	}
}
