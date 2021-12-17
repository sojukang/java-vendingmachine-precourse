package vendingmachine.model.gettable;

import vendingmachine.ValidationUtils;

public class Remains implements Gettable {
	@Override
	public void check(String input) {
		int remains = ValidationUtils.validNoFormat(input);
		ValidationUtils.moneyGreaterThanRemainsMin(remains);
		ValidationUtils.validUnitNo(remains);
	}
}
