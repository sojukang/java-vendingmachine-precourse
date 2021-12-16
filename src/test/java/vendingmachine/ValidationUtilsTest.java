package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.UserMoney;

public class ValidationUtilsTest {
	@Test
	@DisplayName("금액 10으로 나누어 떨어지는지 테스트")
	void validUnitMoneyTest() {
		int money = 111;
		assertThatThrownBy(() -> {
			ValidationUtils.validUnitMoney(money);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자가 아닌 경우 테스트")
	void validNumberFormatTest() {
		String num = "a1";
		String num2 = "[[]";
		assertThatThrownBy(() -> {
			ValidationUtils.validNumberFormat(num);
			ValidationUtils.validNumberFormat(num2);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력이 자연수가 아닌 경우 테스트")
	void isPositiveTest() {
		int num = 0;
		int num2 = -1;
		assertThatThrownBy(() -> {
			ValidationUtils.isPositive(num);
			ValidationUtils.isPositive(num2);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력이 공백인 경우 테스트")
	void isBlankTest() {
		String input = "";
		assertThatThrownBy(() -> {
			ValidationUtils.isBlank(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력 금액 예외 처리")
	void validTest() {
		String UserInputMoney = "5";
		String UserInputMoney2 = "-1";
		String UserInputMoney3 = "a1";
		assertThatThrownBy(() -> {
			ValidationUtils.validMoneyInput(UserInputMoney);
			ValidationUtils.validMoneyInput(UserInputMoney2);
			ValidationUtils.validMoneyInput(UserInputMoney3);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
