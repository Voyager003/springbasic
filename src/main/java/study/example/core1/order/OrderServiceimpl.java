package study.example.core1.order;

import study.example.core1.discount.DIscountPolicy;
import study.example.core1.discount.FixDiscountPolicy;
import study.example.core1.member.Member;
import study.example.core1.member.MemberRepository;
import study.example.core1.member.MemoryMemberRepository;

public class OrderServiceimpl implements OrderService{

    private final MemberRepository memberRepository= new MemoryMemberRepository();
    private final DIscountPolicy dIscountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemname, int itemPrice) {
        Member member = memberRepository.findbyId(memberId);
        int discountPrice = dIscountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemname, itemPrice, discountPrice);
    }
}