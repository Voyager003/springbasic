package study.example.core1.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.example.core1.discount.DIscountPolicy;
import study.example.core1.discount.FixDiscountPolicy;
import study.example.core1.discount.RateDiscountPolicy;
import study.example.core1.member.Member;
import study.example.core1.member.MemberRepository;
import study.example.core1.member.MemoryMemberRepository;


@Component
public class OrderServiceimpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DIscountPolicy dIscountPolicy;

    @Autowired
    public OrderServiceimpl(MemberRepository memberRepository, DIscountPolicy dIscountPolicy) {
        this.memberRepository = memberRepository;
        this.dIscountPolicy = dIscountPolicy;
    }




    @Override
    public Order createOrder(Long memberId, String itemname, int itemPrice) {
        Member member = memberRepository.findbyId(memberId);
        int discountPrice = dIscountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemname, itemPrice, discountPrice);
    }
    //TEst용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
