package vendingmachine.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {

	private HashMap<Integer, Integer> coins;

	public Coins(List<Coin> coinList) {
		this.coins = new HashMap<>();
		coinList.stream()
			.filter(coin -> coins.get(coin.getValue()) == null)
			.forEach(coin -> coins.put(coin.getValue(), 0));
	}

	public Coins() {
		this(Arrays.asList(Coin.values()));
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
