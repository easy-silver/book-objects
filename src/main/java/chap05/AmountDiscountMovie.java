package chap05;

import java.time.Duration;

/**
 * 금액 할인 적용 영화
 */
public class AmountDiscountMovie extends Movie {

    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime,
                               Money fee, Money discountAmount, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }

}
