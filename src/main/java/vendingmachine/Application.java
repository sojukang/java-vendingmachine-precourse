package vendingmachine;

public class Application {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(InputView.getRemains());
		machine.saveInStock(InputView.getItemStatus());
		machine.registerUserMoney(new UserMoney(InputView.getUserMoney()));
		while (machine.canBuySomething()) {
			ResultView.printRemainUserMoney(machine);
			machine.buyItem(InputView.getItemToBuy());
		}
		machine.returnChange();
	}
}
