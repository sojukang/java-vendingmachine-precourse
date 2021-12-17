package vendingmachine.model;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.model.gettable.Coin;
import vendingmachine.model.gettable.Coins;
import vendingmachine.model.gettable.Items;
import vendingmachine.model.gettable.UserMoney;

public class VendingMachine {
	private static final int GENERATE_ALL_COINS = 0;
	private final Coins coins;
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

	public void registerUserMoney(UserMoney userMoney) {
		this.userMoney = userMoney;
	}

	public void saveInStock(String userInputItems) {
		this.items = new Items(userInputItems);
	}

	public void buyItem(String itemName) {
		this.items.buyItem(itemName, this.userMoney);
	}

	public boolean canBuySomething() {
		return !this.items.isAllOutOfStock() && !this.userMoney.canNotBuy(this.items.minPrice());
	}

	public Coins returnChange() {
		return this.coins.getChange(userMoney);
	}

	public int getRemainUserMoney() {
		return this.userMoney.getUserMoney();
	}

	public Coins getCoins() {
		return this.coins;
	}

}
