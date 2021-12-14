package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int count;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getValue() {
        return amount;
    }

    public boolean sameValue(int coinValue) {
        return amount == coinValue;
    }

    public void addCount(int addCount) {
        count += addCount;
    }

    // 추가 기능 구현
}
