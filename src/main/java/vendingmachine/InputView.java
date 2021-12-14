package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
	private static final String GET_ITEM_TO_ADD = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String GET_USER_MONEY = "\n투입 금액을 입력해 주세요.";

	public static void printGetItemToAdd() {
		System.out.println(GET_ITEM_TO_ADD);
	}

	public static String getItemToAdd() {
		return readLine();
	}

	public static int GetUserMoney() {
		return getUserInput(GET_USER_MONEY);
	}

	private static int getUserInput(String getUserInput) {
		while(true) {
			try {
				System.out.println(getUserInput);
				String userInput = readLine();
				return UserMoney.valid(userInput);
			} catch (IllegalArgumentException e) {}
		}
	}
}
