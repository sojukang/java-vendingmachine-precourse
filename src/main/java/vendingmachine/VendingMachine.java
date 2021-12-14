package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {
	private static final int GENERATE_ALL_COINS = 0;
	private static final String ERROR_NOT_IN_STOCK = "[ERROR] 해당 상품이 없습니다.";
	private List<Coin> coins = new ArrayList<>();

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
		this.coins = coinList;
		return coinList;
	}

	private void addCoinCount(List<Coin> coinList, int coinValue) {
		for (Coin coin : coinList) {
			if (coin.sameValue(coinValue)) {
				coin.addCount(1);
			}
		}
	}

	public void buyItem(String itemName, Items items, UserMoney userMoney) {
		if (!items.hasItem(itemName)) {
			throw new IllegalArgumentException(ERROR_NOT_IN_STOCK);
		}
			items.sellItem(itemName, userMoney);
	}

	public boolean canNotBuyAnything(UserMoney userMoney, Items items) {
		return userMoney.canNotBuy(items.minPrice()) || items.allOutOfStock();
	}

	public HashMap<Integer, Integer> returnChange(UserMoney userMoney) {
		HashMap<Integer, Integer> change = new HashMap<>();
		int coinCount;
		for (Coin coin : this.coins) {
			coinCount = coin.toChange(userMoney);
			System.out.println("coinCount: " + coinCount);
			if (coinCount > 0) {
				System.out.println("??");
				change.put(coin.getValue(), coinCount);
			}
		}
		System.out.println(change.get(500));
		System.out.println(change.get(100));
		System.out.println(change.get(50));
		System.out.println(change.get(10));
		return change;
	}
}
