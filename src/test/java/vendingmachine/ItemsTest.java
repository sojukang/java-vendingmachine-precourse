package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemsTest {
	@Test
	@DisplayName("상품 존재 여부 확인 기능 테스트")
	void hasItemTest() {
		String itemName = "사이다";
		String itemName2 = "콜라";
		Item testItem = new Item("[콜라,1000,3]");
		Items testItems = new Items();
		testItems.addItem(testItem);
		assertThat(testItems.hasItem(itemName)).isFalse();
		assertThat(testItems.hasItem(itemName2)).isTrue();
	}

	@Test
	@DisplayName("상품명 중복 예외처리 테스트")
	void alreadyInStockTest() {
		Item testItem = new Item("[콜라,1000,3]");
		Items testItems = new Items();
		testItems.addItem(testItem);
		Item testItem2 = new Item("[콜라,2000,3]");
		assertThatThrownBy(() -> {
			testItems.addItem(testItem2);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
