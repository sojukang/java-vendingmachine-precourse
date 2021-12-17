package vendingmachine.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vendingmachine.model.Index;

public class Parser {
	public static List<String> parseItemStatus(String input) {
		return removeBlank(splitByComma(removeBracket(input)));
	}

	public static String[] splitBySemicolon(String input) {
		return input.split(";");
	}

	public static String removeBracket(String input) {
		if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
			throw new IllegalArgumentException(Messages.Error.INVALID_ITEM);
		}
		return input.substring(1, input.length() - 1);
	}

	public static List<String> removeBlank(String[] input) {
		return Stream.of(input).map(String::trim).collect(Collectors.toList());
	}

	public static String[] splitByComma(String input) {
		return input.split(",");
	}

	public static String parseName(String input) {
		return parseItemStatus(input).get(Index.NAME);
	}
}
