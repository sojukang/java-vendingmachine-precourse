package vendingmachine.domain;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	private int count;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getValue() {
		return amount;
	}

	public boolean sameValue(int coinValue) {
		return amount == coinValue;
	}

	public void addCount(int addCount) {
		this.count += addCount;
	}

	public int toChange(UserMoney userMoney) {
		int coinCount = Math.min(count, userMoney.getNoOfChange(amount));
		userMoney.buy(coinCount * amount);
		subCount(coinCount);
		return coinCount;
	}

	private void subCount(int subCount) {
		this.count -= subCount;
	}

	public int getCount() {
		return this.count;
	}
}
