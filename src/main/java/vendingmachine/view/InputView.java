package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;

import vendingmachine.domain.UserMoney;

public class InputView {
	private static final String GET_ITEM_TO_ADD = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String GET_USER_MONEY = "\n투입 금액을 입력해 주세요.";
	private static final String GET_REMAINS = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String GET_ITEM_TO_BUY = "구매할 상품명을 입력해 주세요.";

	public static void printGetItemToAdd() {
		System.out.println(GET_ITEM_TO_ADD);
	}

	public static String getItemToAdd() {
		return readLine();
	}

	public static int getUserMoney() {
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

	public static int getRemains() {
		return getUserInput(GET_REMAINS);
	}

	public static String getItemToBuy(UserMoney userMoney) {
		System.out.println("\n투입 금액: " + userMoney.getUserMoney() + "원");
		System.out.println(GET_ITEM_TO_BUY);
		return readLine();
	}
}
