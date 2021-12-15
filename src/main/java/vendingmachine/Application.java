package vendingmachine;

import vendingmachine.domain.Items;
import vendingmachine.domain.UserMoney;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.ResultView;

public class Application {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(InputView.getRemains());
		ResultView.printRemainCoins(machine.getRaminCoins());
		machine.saveInStock(getItems());
		machine.registerUserMoney(new UserMoney(InputView.getUserMoney()));
		while (!machine.canNotBuyAnything() && canGetItemToBuy(machine))
		ResultView.printRemainUserMoney(machine);
		ResultView.printChange(machine.returnChange());
	}

	public static Items getItems() {
		while (true) {
			try {
				InputView.printGetItemToAdd();
				String[] itemToAdd = ValidationUtils.validItemsInput(InputView.getItemToAdd());
				Items items = new Items();
				items.addItems(itemToAdd);
				return items;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static boolean canGetItemToBuy(VendingMachine machine) {
		while (true) {
			try {
				String inputMoney = InputView.getItemToBuy(machine);
				machine.buyItem(inputMoney);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
