package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class UserMoney {
	public static int valid(String UserInputMoney) {
		int userMoney = validNumberFormat(UserInputMoney);
		validUnitMoney(userMoney);
		isPositive(userMoney);
		return userMoney;
	}
}
