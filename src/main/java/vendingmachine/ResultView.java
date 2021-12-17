package vendingmachine;

public class ResultView {
	public static void printRemainUserMoney(VendingMachine machine) {
		System.out.println("투입금액: " + machine.getRemainUserMoney() + "원");
	}
}
