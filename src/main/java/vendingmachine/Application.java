package vendingmachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
