package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coins;
import vendingmachine.domain.VendingMachine;

public class ResultView {
	private static final String REMAINS_MESSAGE = "\n자판기가 보유한 동전";

	public static void printRemainCoins(Coins remainCoins) {
		System.out.println(REMAINS_MESSAGE);
		for (Map.Entry<Integer, Integer> entrySet : remainCoins.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
	}

	public static void printChange(Coins change) {
		for (Map.Entry<Integer, Integer> entrySet : change.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
	}

	public static void printRemainUserMoney(VendingMachine machine) {
		System.out.println("\n투입 금액: " + machine.getRemainUserMoney() + "원\n" + "잔돈");
	}
}
