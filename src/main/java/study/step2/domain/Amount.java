package study.step2.domain;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void valid(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("유효하지 않는 금액입니다.");
        }
    }

    public int divide(int lottoPrice) {
        return this.amount/lottoPrice;
    }
}
