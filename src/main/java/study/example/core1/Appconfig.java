package study.example.core1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.example.core1.discount.DIscountPolicy;
import study.example.core1.discount.FixDiscountPolicy;
import study.example.core1.discount.RateDiscountPolicy;
import study.example.core1.member.MemberRepository;
import study.example.core1.member.MemberService;
import study.example.core1.member.MemberServiceImpl;
import study.example.core1.member.MemoryMemberRepository;
import study.example.core1.order.OrderService;
import study.example.core1.order.OrderServiceimpl;

@Configuration

public class Appconfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call Appconfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call Appconfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call Appconfig.orderService");
        return new OrderServiceimpl(memberRepository(), dIscountPolicy());
    }
    @Bean
    public DIscountPolicy dIscountPolicy() {
        return new RateDiscountPolicy();
    }
}
