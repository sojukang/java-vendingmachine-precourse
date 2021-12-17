package vendingmachine.model.gettable;

import vendingmachine.ValidationUtils;

public class UserMoney implements Gettable {
	private int userMoney;

	public UserMoney(String userMoney) {
		this.userMoney = Integer.parseInt(userMoney);
	}

	public UserMoney() {

	}

	@Override
	public void check(String input) {
		int userMoney = ValidationUtils.validNoFormat(input);
		ValidationUtils.validUnitNo(userMoney);
		ValidationUtils.moneyGreaterThanUserMoneyMin(userMoney);
	}

	public void buy(int price) {
		if (userMoney >= price) {
			userMoney -= price;
		}
	}

	public boolean canNotBuy(int minPrice) {
		return userMoney < minPrice;
	}

	public int getNoOfChange(int coinValue) {
		return this.userMoney / coinValue;
	}

	public int getUserMoney() {
		return this.userMoney;
	}
}
