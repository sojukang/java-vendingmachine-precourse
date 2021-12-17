package vendingmachine;

import java.util.Arrays;
import java.util.Collection;
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

	public void addCount(int coinVal, int count) {
		if (count > 0) {
			coins.put(coinVal, coins.get(coinVal) + count);
		}
	}

	public Coins getChange(UserMoney userMoney) {
		Coins change = new Coins();
		for (int coin : this.coins.keySet()) {
			change.addCount(coin, getCount(coin, userMoney));
		}
		return change;
	}

	private int getCount(int coinVal, UserMoney userMoney) {
		int coinCount = Math.min(coins.get(coinVal), userMoney.getNoOfChange(coinVal));
		userMoney.buy(coinCount * coinVal);
		coins.put(coinVal, coins.get(coinVal) - coinCount);
		return coinCount;
	}

	public Collection<Map.Entry<Integer, Integer>> entrySet() {
		return this.coins.entrySet();
	}
}
