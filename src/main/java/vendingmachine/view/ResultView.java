package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coins;
import vendingmachine.domain.VendingMachine;

public class ResultView {
	public static void printCoins(Coins coins, String message) {
		System.out.println(message);
		for (Map.Entry<Integer, Integer> entrySet : coins.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
	}

	public static void printRemainCoins(Coins remainCoins) {
		printCoins(remainCoins, Messages.REMAINS_MESSAGE);
	}

	public static void printChange(VendingMachine machine) {
		String message = "\n투입 금액: " + machine.getRemainUserMoney() + "원\n" + "잔돈";
		printCoins(machine.returnChange(), message);
	}
}
