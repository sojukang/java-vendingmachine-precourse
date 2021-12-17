package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private static final int GENERATE_ALL_COINS = 0;

	private int generateRandomCoin() {
		List<Integer> coins = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coins.add(coin.getValue());
		}
		return pickNumberInList(coins);
	}

	public Coins generateRemainCoins(int remains) {
		Coins coins = new Coins();
		while (remains != GENERATE_ALL_COINS) {
			int newCoin = generateRandomCoin();
			if (remains < newCoin) {
				continue;
			}
			remains -= newCoin;
			coins.addCount(newCoin, 1);
		}
		return coins;
	}
}
