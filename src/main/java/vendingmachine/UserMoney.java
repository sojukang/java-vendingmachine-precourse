package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class UserMoney {
	public static void valid(String UserInputMoney) {
		int userMoney = validNumberFormat(UserInputMoney);
		validUnitMoney(userMoney);
		isPositive(userMoney);
	}
}
