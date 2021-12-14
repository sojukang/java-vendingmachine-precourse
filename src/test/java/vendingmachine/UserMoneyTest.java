package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.UserMoney;

public class UserMoneyTest {
	@Test
	@DisplayName("투입 금액 예외 처리")
	void validTest() {
		String UserInputMoney = "5";
		String UserInputMoney2 = "-1";
		String UserInputMoney3 = "a1";
		assertThatThrownBy(() -> {
			UserMoney.valid(UserInputMoney);
			UserMoney.valid(UserInputMoney2);
			UserMoney.valid(UserInputMoney3);
		}).isInstanceOf(IllegalArgumentException.class);

	}
}
