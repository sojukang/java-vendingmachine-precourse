package vendingmachine;

public class UserMoney {
	private int userMoney;

	public UserMoney(String input) {
		this.userMoney = validUserMoney(input);
	}

	private int validUserMoney(String input) {
		int userMoney = ValidationUtils.validNoFormat(input);
		ValidationUtils.validUnitNo(userMoney);
		ValidationUtils.moneyGreaterThanUserMoneyMin(userMoney);
		return userMoney;
	}

	public void buy(int price) {
		userMoney -= price;
	}

	public boolean canNotBuy(int minPrice) {
		return userMoney <= minPrice;
	}

	public int getNoOfChange(int coinValue) {
		return this.userMoney / coinValue;
	}
}
