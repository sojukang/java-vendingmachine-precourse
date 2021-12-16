package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.view.InputView;

public class InputViewTest {
	@ParameterizedTest
	@ValueSource(strings = {"a", "1", " ", "-1", "5"})
	void getUserMoneyTest(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertThatThrownBy(() -> {
			InputView.getUserInput("");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
