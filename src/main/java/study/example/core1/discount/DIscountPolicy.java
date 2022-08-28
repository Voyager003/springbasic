package study.example.core1.discount;

import study.example.core1.member.Member;

public interface DIscountPolicy {
    /**
     * return 할인 대상 금액
     */
    int discount(Member member, int price);
}
