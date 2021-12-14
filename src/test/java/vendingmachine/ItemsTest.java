package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemsTest {
	@Test
	@DisplayName("상품명 목록에 없을 경우 테스트")
	void hasItemTest() {
		String itemName = "사이다";
		String itemName2 = "콜라";
		Item testItem = new Item("[콜라,1000,3]");
		Items testItems = new Items();
		testItems.addItem(testItem);
		assertThat(testItems.hasItem(itemName)).isFalse();
		assertThat(testItems.hasItem(itemName2)).isTrue();
	}
}
