package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
	private static final int GENERATE_ALL_COINS = 0;
	private List<Coin> coins;

	private int generateRandomCoin() {
		List<Integer> coins = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coins.add(coin.getValue());
		}
		return pickNumberInList(coins);
	}

	public List<Coin> generateRemainCoins(int remains) {
		List<Coin> coinList = Arrays.asList(Coin.values());
		while (remains != GENERATE_ALL_COINS) {
			int newCoin = generateRandomCoin();
			if (remains < newCoin) {
				continue;
			}
			remains -= newCoin;
			addCoinCount(coinList, newCoin);
		}
		coins = coinList;
		return coins;
	}

	private void addCoinCount(List<Coin> coinList, int coinValue) {
		for (Coin coin : coinList) {
			if (coin.sameValue(coinValue)) {
				coin.addCount(1);
			}
		}
	}
}
