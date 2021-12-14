package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
	@Test
	@DisplayName("금액 10으로 나누어 떨어지는지 테스트")
	void validUnitMoneyTest() {
		int money = 111;
		assertThatThrownBy(() -> {
			ValidationUtils.validUnitMoney(money);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
