package vendingmachine;

import java.util.Map;

public class ResultView {
	public static void printRemainUserMoney(VendingMachine machine) {
		System.out.println("투입금액: " + machine.getRemainUserMoney() + "원");
	}

	public static void printCoins(VendingMachine machine, String message) {
		System.out.println(message);
		Coins coins = machine.getCoins();
		for (Map.Entry<Integer, Integer> entrySet : coins.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
		System.out.println();
	}

	public static void printRemainCoins(VendingMachine machine) {
		printCoins(machine, Messages.REMAINS_MESSAGE);
	}
}
