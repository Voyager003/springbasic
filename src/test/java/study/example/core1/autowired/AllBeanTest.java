package study.example.core1.autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.example.core1.AutoAppConfig;
import study.example.core1.discount.DIscountPolicy;
import study.example.core1.member.Grade;
import study.example.core1.member.Member;

import java.util.Map;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac =  new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L,"userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);



    }


    static class DiscountService {
        private final Map<String, DIscountPolicy> policyMap;
        private final List<DIscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DIscountPolicy> policyMap, List<DIscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode){
            DIscountPolicy dIscountPolicy = policyMap.get(discountCode);
            return dIscountPolicy.discount(member, price);
        }
    }
}
