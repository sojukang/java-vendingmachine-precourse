package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTest {
	@Test
	@DisplayName("상품명 공백인지 확인")
	void validNameTest() {
		String name = "";
		assertThatThrownBy(() -> {
			Item.validName(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("상품 가격 검증")
	void validPrice() {
		String price = "-1";
		String price2 = "0";
		String price3 = "a1";
		assertThatThrownBy(() -> {
			Item.validPrice(price);
			Item.validPrice(price2);
			Item.validPrice(price3);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("상품 수량 검증")
	void validCount() {
		String count = "-1";
		String count2 = "0";
		String count3 = "a1";
		assertThatThrownBy(() -> {
			Item.validCount(count);
			Item.validCount(count2);
			Item.validCount(count3);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("상품 정보 입력 검증")
	void validItemStatus() {
		String itemStatus = "[콜라, 1101, 3]";
		String itemStatus2 = "[콜라, 1100, -1]";
		String itemStatus3 = "[, 1101, 3]";
		assertThatThrownBy(() -> {
			Item.validItemStatus(itemStatus);
			Item.validItemStatus(itemStatus2);
			Item.validItemStatus(itemStatus3);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
