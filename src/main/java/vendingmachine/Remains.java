package vendingmachine;

public class Remains implements Gettable {
	public void check(String input) {
		int remains = ValidationUtils.validNoFormat(input);
		ValidationUtils.moneyGreaterThanRemainsMin(remains);
		ValidationUtils.validUnitNo(remains);
	}
}
