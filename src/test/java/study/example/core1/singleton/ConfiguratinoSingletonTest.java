package study.example.core1.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.example.core1.Appconfig;
import study.example.core1.member.MemberRepository;
import study.example.core1.member.MemberServiceImpl;
import study.example.core1.order.OrderServiceimpl;

public class ConfiguratinoSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceimpl orderservice = ac.getBean("orderService", OrderServiceimpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderservice.getMemberRepository();

        System.out.println("memberService -> memberRepository " + memberRepository1);
        System.out.println("orderService -> memberRepository " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderservice.getMemberRepository()).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        Appconfig bean = ac.getBean(Appconfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
