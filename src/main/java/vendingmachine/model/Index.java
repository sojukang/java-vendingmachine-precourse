package vendingmachine.model;

public class Index {
	public static final int NAME = 0;
	public static final int PRICE = 1;
	public static final int COUNT = 2;
	public static final int LEFT_BRACKET = 0;
	public static final int AFTER_LEFT_BRACKET = 1;

	public static int RIGHT_BRACKET(String input) {
		return input.length() - 1;
	}
}
