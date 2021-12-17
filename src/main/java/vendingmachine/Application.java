package vendingmachine;

import vendingmachine.model.gettable.UserMoney;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.ResultView;

public class Application {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(InputView.getRemains());
		ResultView.printRemainCoins(machine.getCoins());
		machine.saveInStock(InputView.getItemStatus());
		machine.registerUserMoney(new UserMoney(InputView.getUserMoney()));
		buyItem(machine);
		ResultView.printChange(machine.returnChange());
	}

	private static void buyItem(VendingMachine machine) {
		while (machine.canBuySomething()) {
			try {
				ResultView.printRemainUserMoney(machine);
				machine.buyItem(InputView.getItemToBuy());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
