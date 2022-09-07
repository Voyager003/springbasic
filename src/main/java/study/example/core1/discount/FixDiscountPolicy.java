package study.example.core1.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.example.core1.member.Grade;
import study.example.core1.member.Member;

@Component
public class FixDiscountPolicy implements DIscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }

    }
}
