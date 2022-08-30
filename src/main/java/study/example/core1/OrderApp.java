package study.example.core1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.example.core1.member.Grade;
import study.example.core1.member.Member;
import study.example.core1.member.MemberService;
import study.example.core1.member.MemberServiceImpl;
import study.example.core1.order.Order;
import study.example.core1.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
//        Appconfig appconfig = new Appconfig();
//        MemberService memberService = appconfig.memberService();
//        OrderService orderService = appconfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+ order);
    }

}
