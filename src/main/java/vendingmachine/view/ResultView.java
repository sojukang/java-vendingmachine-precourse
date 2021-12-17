package vendingmachine.view;

import java.util.Map;

import vendingmachine.model.gettable.Coins;
import vendingmachine.model.VendingMachine;

public class ResultView {
	public static void printRemainUserMoney(VendingMachine machine) {
		System.out.println("투입 금액: " + machine.getRemainUserMoney() + "원");
	}

	public static void printCoins(Coins coins, String message) {
		System.out.println(message);
		for (Map.Entry<Integer, Integer> entrySet : coins.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
		System.out.println();
	}

	public static void printRemainCoins(Coins remainCoins) {
		printCoins(remainCoins, Messages.REMAINS_MESSAGE);
	}

	public static void printChange(Coins change) {
		printCoins(change, Messages.CHANGE);
	}
}
