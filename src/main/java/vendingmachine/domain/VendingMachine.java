package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.view.Messages;

public class VendingMachine {
	private static final int GENERATE_ALL_COINS = 0;
	private Coins coins;
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

	public void buyItem(String itemName) {
		if (!items.hasItem(itemName)) {
			throw new IllegalArgumentException(Messages.ERROR_NOT_IN_STOCK);
		}
		items.sellItem(itemName, userMoney);
	}

	public boolean canNotBuyAnything() {
		return userMoney.canNotBuy(items.minPrice()) || items.allOutOfStock();
	}

	public Coins returnChange() {
		Coins change = new Coins();
		int coinCount;
		for (int coin : this.coins.keySet()) {
			coinCount = coins.toChange(coin, userMoney);
			if (coinCount > 0) {
				change.addCount(coin, coinCount);
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

	public Coins getRemainCoins() {
		return this.coins;
	}
}
