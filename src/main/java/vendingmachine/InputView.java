package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
	private static final String GET_ITEM_TO_ADD = "\n상품명과 가격, 수량을 입력해 주세요.";

	public static void printGetItemToAdd() {
		System.out.println(GET_ITEM_TO_ADD);
	}

	public static String getItemToAdd() {
		return readLine();
	}
}
