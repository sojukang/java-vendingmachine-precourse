package vendingmachine.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.UserMoney;
import vendingmachine.domain.VendingMachine;

public class ResultView {
	private static final String REMAINS_MESSAGE = "\n자판기가 보유한 동전";

	public static void printRemainCoins(List<Coin> remainCoins) {
		System.out.println(REMAINS_MESSAGE);
		for (Coin coin : remainCoins) {
			System.out.println(coin.getValue() + "원 - " + coin.getCount() + "개");
		}
	}

	public static void printChange(LinkedHashMap<Integer, Integer> change) {
		for (Map.Entry<Integer, Integer> entrySet : change.entrySet()) {
			System.out.println(entrySet.getKey() + "원 - " + entrySet.getValue() + "개");
		}
	}

	public static void printRemainUserMoney(VendingMachine machine) {
		System.out.println("\n투입 금액: " + machine.getRemainUserMoney() + "원\n" + "잔돈");
	}
}
