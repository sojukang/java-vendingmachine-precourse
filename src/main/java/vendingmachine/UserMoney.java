package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class UserMoney {
	private int userMoney;

	public UserMoney(int userInputMoney) {
		userMoney = userInputMoney;
	}

	public static int valid(String UserInputMoney) {
		int userMoney = validNumberFormat(UserInputMoney);
		validUnitMoney(userMoney);
		isPositive(userMoney);
		return userMoney;
	}

	public void buy(int price) {
		userMoney -= price;
	}

	public boolean canNotBuy(int minPrice) {
		return userMoney < minPrice;
	}

	public int getUserMoney() {
		return userMoney;
	}
}
