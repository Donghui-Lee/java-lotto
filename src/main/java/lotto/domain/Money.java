package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    private void validate(int money) {
        if ((money < 0) || (money % LOTTO_PRICE != 0)) {
            throw new IllegalArgumentException("로또 구매 최저 금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }

    public int countOfLotto() {
        return this.money / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money1 = (Money)o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
