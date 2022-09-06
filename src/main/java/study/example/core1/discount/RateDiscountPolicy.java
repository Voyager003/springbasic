package study.example.core1.discount;

import org.springframework.stereotype.Component;
import study.example.core1.member.Grade;
import study.example.core1.member.Member;


@Component
public class RateDiscountPolicy implements DIscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()==Grade.VIP){
            return  price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
