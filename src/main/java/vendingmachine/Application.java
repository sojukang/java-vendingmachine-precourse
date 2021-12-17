package vendingmachine;

public class Application {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(InputView.getRemains());
		machine.saveInStock(InputView.getItemStatus());
		machine.registerUserMoney(new UserMoney(InputView.getUserMoney()));
		while (machine.canBuySomething()) {
			machine.buyItem("콜라");
			machine.buyItem("사이다");
		}
		machine.returnChange();
	}
}
