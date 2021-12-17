package vendingmachine.view;

public class Messages {
	public class Error {
		public static final String NOT_INT = "[ERROR] 금액은 숫자여야 합니다.";
		public static final String INVALID_UNIT_NO = "[ERROR] 금액은 10원 단위어야 합니다.";
		public static final String SMALLER_THAN_MIN = "[ERROR] 금액이 최소 금액보다 작습니다.";
		public static final String INVALID_ITEM = "[ERROR] 잘못된 상품 입력입니다.";
		public static final String BLANK = "[ERROR] 빈 문자열 입력입니다.";
		public static final String GREATER_THAN_ZERO = "[ERROR] 입력은 0보다 커야합니다.";
		public static final String NOT_IN_STOCK = "[ERROR] 해당 아이템이 존재하지 않습니다.";
	}

	public static final String GET_REMAINS = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String GET_USER_MONEY = "투입 금액을 입력해 주세요.";
	public static final String GET_ITEM_STATUS = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String GET_ITEM_TO_BUY = "구매할 상품명을 입력해 주세요.";
	public static final String REMAINS_MESSAGE = "자판기가 보유한 동전";
	public static final String CHANGE = "잔돈";
}
