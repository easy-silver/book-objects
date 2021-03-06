package chap02;

import chap02.discount.policy.DiscountPolicy;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        //discountPolicy에 calculateDiscountAmount 메시지 전송 -> 할인 요금을 반환받는다.
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    //할인 정책 변경(인터페이스로 지정했기 때문에 유연하게 다양한 구현체들로 변경 가능함
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

}
