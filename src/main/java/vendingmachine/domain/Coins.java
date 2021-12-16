package vendingmachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Coins {
	private final Map<Integer, Integer> coins;

	public Coins() {
		Comparator<Integer> comparator = Comparator.reverseOrder();
		this.coins = new TreeMap<>(comparator);
		Arrays.stream(Coin.values())
			.filter(coin -> coins.get(coin.getValue()) == null)
			.forEach(coin -> coins.put(coin.getValue(), 0));
	}

	public void addCount(int newCoin, int coinCount) {
		if (coinCount > 0) {
			coins.put(newCoin, coins.get(newCoin) + coinCount);
		}
	}

	public Iterable<? extends Integer> keySet() {
		return coins.keySet();
	}

	public int getCount(int coin, UserMoney userMoney) {
		int coinCount = Math.min(coins.get(coin), userMoney.getNoOfChange(coin));
		userMoney.buy(coinCount * coin);
		coins.put(coin, coins.get(coin) - coinCount);
		return coinCount;
	}

	public Coins getChange(UserMoney userMoney) {
		Coins change = new Coins();
		for (int coin : this.coins.keySet()) {
			change.addCount(coin, getCount(coin, userMoney));
		}
		return change;
	}

	public Iterable<? extends Map.Entry<Integer, Integer>> entrySet() {
		return coins.entrySet();
	}
}
