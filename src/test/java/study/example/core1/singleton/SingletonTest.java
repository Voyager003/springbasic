package study.example.core1.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.example.core1.Appconfig;
import study.example.core1.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("Spring 없는 순수 DI 컨테이너")
    void pureContainer() {
        Appconfig appconfig = new Appconfig();
        // 1. 조회: 호출 할때마다 객체 생성
        MemberService memberService1 = appconfig.memberService();

        // 2. 조회 : 호출 할때마다 객체 생성
        MemberService memberService2 = appconfig.memberService();

        //참조 값이 다른 것을 확인
        System.out.println("memberService1 = "+memberService1);
        System.out.println("memberService2 = "+memberService2);
        // mems1 /= mems2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

    }

    @Test
    @DisplayName("Spring container singleton")
    void springContainer(){
        // Appconfig appconfig = new Appconfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조 값이 다른 것을 확인
        System.out.println("memberService1 = "+memberService1);
        System.out.println("memberService2 = "+memberService2);
        // mems1 /= mems2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
