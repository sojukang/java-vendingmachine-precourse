package vendingmachine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import com.sun.javafx.css.StyleCacheEntry;

public class Coins {

	private Map<Integer, Integer> coins;

	public Coins() {
		Comparator<Integer> comparator = Comparator.reverseOrder();
		this.coins = new TreeMap<>(comparator);
		Arrays.stream(Coin.values())
			.filter(coin -> coins.get(coin.getValue()) == null)
			.forEach(coin -> coins.put(coin.getValue(), 0));
	}

	public void addCount(int coin, int count) {
		coins.put(coin, coins.get(coin) + count);
	}
}
