package vendingmachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(InputView.getRemains());
        String ItemStatus = "[콜라,1500,20];[사이다,1000,10]";
        machine.saveInStock(ItemStatus);
        machine.registerUserMoney(new UserMoney("3000"));
        while (machine.canBuySomething()) {
            machine.buyItem("콜라");
            machine.buyItem("사이다");
        }
        machine.returnChange();
    }
}
