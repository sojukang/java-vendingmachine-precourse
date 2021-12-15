package vendingmachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Coins {
	private Map<Integer, Integer> coins;

	public Coins() {
		Comparator<Integer> comparator = Comparator.reverseOrder();
		this.coins = new TreeMap<>(comparator);
		Arrays.stream(Coin.values())
			.filter(coin -> coins.get(coin.getValue()) == null)
			.forEach(coin -> coins.put(coin.getValue(), 0));
	}

	public void addCount(int newCoin, int coinCount) {
		coins.put(newCoin, coins.get(newCoin) + coinCount);
	}

	public Iterable<? extends Integer> keySet() {
		return coins.keySet();
	}

	public int toChange(int coin, UserMoney userMoney) {
		int coinCount = Math.min(coins.get(coin), userMoney.getNoOfChange(coin));
		userMoney.buy(coinCount * coin);
		coins.put(coin, coins.get(coin) - coinCount);
		return coinCount;
	}

	public Iterable<? extends Map.Entry<Integer, Integer>> entrySet() {
		return coins.entrySet();
	}
}
