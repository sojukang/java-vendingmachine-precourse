package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.Item;

public class ItemTest {
	@Test
	@DisplayName("상품명 공백인지 확인")
	void validNameTest() {
		String name = "";
		assertThatThrownBy(() -> {
			Item.validName(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "a1", "a", "5"})
	@DisplayName("상품 가격 검증")
	void validPrice(String input) {
		assertThatThrownBy(() -> {
			Item.validPrice(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "a1", "a"})
	@DisplayName("상품 수량 검증")
	void validCount(String input) {
		assertThatThrownBy(() -> {
			Item.validCount(input);
		}).isInstanceOf(IllegalArgumentException.class);
		assertThatCode(() -> Item.validCount("5"))
			.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,1101,3]", "[콜라,1100,-1]", "[,1101,3]"})
	@DisplayName("상품 정보 입력 검증")
	void validItemStatus(String input) {
		assertThatThrownBy(() -> {
			Item.validItemStatus(input);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[ 콜라,    1100,3]", "[사이다, 1100,1]", "[Sprite,1100, 3]"})
	@DisplayName("상품 정보 입력 정상 검증")
	void validItemStatusPassTest(String input) {
		assertThatCode(() -> Item.validItemStatus(input))
			.doesNotThrowAnyException();
	}
}
