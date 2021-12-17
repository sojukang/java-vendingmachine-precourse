package vendingmachine;

public class UserMoney {
	private final int userMoney;

	public UserMoney(String input) {
		this.userMoney = validUserMoney(input);
	}

	private int validUserMoney(String input) {
		int userMoney = ValidationUtils.validNoFormat(input);
		ValidationUtils.validUnitNo(userMoney);
		ValidationUtils.moneyGreaterThanUserMoneyMin(userMoney);
		return userMoney;
	}
}
