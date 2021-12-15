package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class VendingMachine {
	private static final int GENERATE_ALL_COINS = 0;
	private static final String ERROR_NOT_IN_STOCK = "[ERROR] 해당 상품이 없습니다.";
	private List<Coin> coins;
	private UserMoney userMoney;
	private Items items;

	public VendingMachine(int remains) {
		this.coins = generateRemainCoins(remains);
	}

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

	public void buyItem(String itemName) {
		if (!items.hasItem(itemName)) {
			throw new IllegalArgumentException(ERROR_NOT_IN_STOCK);
		}
			items.sellItem(itemName, userMoney);
	}

	public boolean canNotBuyAnything() {
		return userMoney.canNotBuy(items.minPrice()) || items.allOutOfStock();
	}

	public LinkedHashMap<Integer, Integer> returnChange() {
		LinkedHashMap<Integer, Integer> change = new LinkedHashMap<>();
		int coinCount;
		for (Coin coin : this.coins) {
			coinCount = coin.toChange(userMoney);
			if (coinCount > 0) {
				change.put(coin.getValue(), coinCount);
			}
		}
		return change;
	}

	public void saveInStock(Items items) {
		this.items = items;
	}

	public void registerUserMoney(UserMoney userMoney) {
		this.userMoney = userMoney;
	}

	public int getRemainUserMoney() {
		return this.userMoney.getUserMoney();
	}

	public List<Coin> getRaminCoins() {
		return this.coins;
	}
}
