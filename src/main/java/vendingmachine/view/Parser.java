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
		if (input.charAt(Index.LEFT_BRACKET) != '[' || input.charAt(Index.RIGHT_BRACKET(input)) != ']') {
			throw new IllegalArgumentException(Messages.Error.INVALID_ITEM);
		}
		return input.substring(Index.AFTER_LEFT_BRACKET, Index.RIGHT_BRACKET(input));
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
