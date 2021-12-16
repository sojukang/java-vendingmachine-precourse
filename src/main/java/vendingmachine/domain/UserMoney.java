package vendingmachine.domain;

public class UserMoney {
	private int userMoney;

	public UserMoney(int userInputMoney) {
		this.userMoney = userInputMoney;
	}

	public void buy(int price) {
		if (this.userMoney >= price) {
			this.userMoney -= price;
		}
	}

	public boolean canNotBuy(int minPrice) {
		return this.userMoney < minPrice;
	}

	public int getUserMoney() {
		return this.userMoney;
	}

	public int getNoOfChange(int coinValue) {
		return this.userMoney / coinValue;
	}
}
