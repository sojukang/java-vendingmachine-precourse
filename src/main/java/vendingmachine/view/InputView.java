package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.model.gettable.Gettable;
import vendingmachine.model.gettable.Item;
import vendingmachine.model.gettable.Items;
import vendingmachine.model.gettable.Remains;
import vendingmachine.model.gettable.UserMoney;

public class InputView {

	public static int getRemains() {
		return Integer.parseInt(repeatInput(Messages.GET_REMAINS, new Remains()));
	}

	public static String getUserMoney() {
		return repeatInput(Messages.GET_USER_MONEY, new UserMoney());
	}

	public static String getItemStatus() {
		return repeatInput(Messages.GET_ITEM_STATUS, new Items());
	}

	public static String getItemToBuy() {
		return getUserInput(Messages.GET_ITEM_TO_BUY, new Item());
	}

	public static String getUserInput(String message, Gettable gettable) {
		System.out.println(message);
		String input = readLine();
		gettable.check(input);
		System.out.println();
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

}
