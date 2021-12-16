package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationUtilsTest {
	@ParameterizedTest
	@ValueSource(strings = {"[", "a", "a1", "1.1"})
	@DisplayName("정수가 아닐 때 검증 테스트")
	void validNoFormatTest(String input) {
		assertThatThrownBy(() -> {
			ValidationUtils.validNoFormat(input);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.ERROR_NOT_INT);
	}
}
