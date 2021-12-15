package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

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
		return getUserInput(Messages.GET_USER_MONEY);
	}

	private static int getUserInput(String getUserInputMessage) {
		while (true) {
			try {
				System.out.println(getUserInputMessage);
				String userInput = readLine();
				return UserMoney.valid(userInput);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int getRemains() {
		return getUserInput(Messages.GET_REMAINS);
	}

	public static String getItemToBuy(VendingMachine machine) {
		System.out.println("\n투입 금액: " + machine.getRemainUserMoney() + "원");
		System.out.println(Messages.GET_ITEM_TO_BUY);
		return readLine();
	}
}
