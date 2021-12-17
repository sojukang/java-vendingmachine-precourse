package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.view.Messages;

public class ValidationUtilsTest {
	@ParameterizedTest
	@ValueSource(strings = {"[", "a", "a1", "1.1"})
	@DisplayName("정수가 아닐 때 검증 테스트")
	void validNoFormatTest(String input) {
		assertThatThrownBy(() -> {
			ValidationUtils.validNoFormat(input);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.Error.NOT_INT);
	}

	@Test
	@DisplayName("10으로 나누어 떨어지지 않을 때 검증 테스트")
	void validUnitMoneyTest() {
		int input = 5;
		assertThatThrownBy(() -> {
			ValidationUtils.validUnitNo(input);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.Error.INVALID_UNIT_NO);
	}

	@Test
	@DisplayName("x원 미만일 때 검증 테스트")
	void moneyGreaterThanTest() {
		int min1 = -10;
		int min2 = 50;
		assertThatThrownBy(() -> {
			ValidationUtils.moneyGreaterThanRemainsMin(min1);
			ValidationUtils.moneyGreaterThanUserMoneyMin(min2);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.Error.SMALLER_THAN_MIN);

	}
}
