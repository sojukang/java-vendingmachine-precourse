package vendingmachine;

import static camp.nextstep.edu.missionutils.Console.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import vendingmachine.view.InputView;
import vendingmachine.view.Messages;

public class InputViewTest {
	@Test
	void getUserMoneyTest() {
		String Input = "a";
		InputStream in = new ByteArrayInputStream(Input.getBytes());
		System.setIn(in);
		assertThatThrownBy(() -> {
			InputView.getUserInput("");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Messages.ERROR_NOT_NUMBER);
	}
}
