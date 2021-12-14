package vendingmachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        int remains = InputView.getRemains();
        ResultView.printRemainCoins(machine.generateRemainCoins(remains));
        Items items = getItems();
        UserMoney userMoney = new UserMoney(InputView.getUserMoney());
        while (!machine.canNotBuyAnything(userMoney, items)) {
            machine.buyItem(InputView.getItemToBuy(userMoney), items, userMoney);
        }
        ResultView.printChange(userMoney, machine.returnChange(userMoney));
    }

    public static Items getItems() {
        InputView.printGetItemToAdd();
        String[] itemToAdd = InputView.getItemToAdd().split(";");
        Items items = new Items();
        for (String itemStatus : itemToAdd) {
            items.addItem(new Item(itemStatus));
        }
        return items;
    }
}
