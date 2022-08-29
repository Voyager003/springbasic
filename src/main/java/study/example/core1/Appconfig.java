package study.example.core1;

import study.example.core1.discount.FixDiscountPolicy;
import study.example.core1.member.MemberService;
import study.example.core1.member.MemberServiceImpl;
import study.example.core1.member.MemoryMemberRepository;
import study.example.core1.order.OrderService;
import study.example.core1.order.OrderServiceimpl;

public class Appconfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceimpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
