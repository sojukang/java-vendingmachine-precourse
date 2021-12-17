package vendingmachine.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.model.gettable.UserMoney;

public class Coins {

	private static final boolean NO_INIT_ZERO = false;
	private Map<Integer, Integer> coins;

	public Coins() {
		this(NO_INIT_ZERO);
		Arrays.stream(Coin.values())
			.filter(coin -> coins.get(coin.getValue()) == null)
			.forEach(coin -> coins.put(coin.getValue(), 0));
	}

	public Coins(boolean init_indicator) {
		Comparator<Integer> comparator = Comparator.reverseOrder();
		this.coins = new TreeMap<>(comparator);
	}

	public void addCount(int coinVal, int count) {
		if (count > 0) {
			coins.put(coinVal, coins.get(coinVal) + count);
		}
	}

	public Coins getChange(UserMoney userMoney) {
		Coins change = new Coins(NO_INIT_ZERO);
		for (int coin : this.coins.keySet()) {
			change.put(coin, getCount(coin, userMoney));
		}
		return change;
	}

	private void put(int coin, int count) {
		if (count > 0) {
			this.coins.put(coin, count);
		}
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
