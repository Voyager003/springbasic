package study.example.core1.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.example.core1.Appconfig;
import study.example.core1.discount.DIscountPolicy;
import study.example.core1.discount.RateDiscountPolicy;

import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AplplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상이면 중복오류 발생")
    void findBeanByParentTypeDuplicate() {
        DIscountPolicy bean = ac.getBean(DIscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DIscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상이면 중복오류 발생")
    void findBeanByParentBeanName() {
        DIscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DIscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeayBySubType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeanByParentType() {
        Map<String, DIscountPolicy> beansOfType = ac.getBeansOfType(DIscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));

        }
    }

    @Test
    @DisplayName("부모타입으로 모두 조회 - Object")
    void findAllBeanByObject() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }


        @Configuration
        static class TestConfig {

            @Bean
            public DIscountPolicy rateDiscountPolicy() {
                return new RateDiscountPolicy();
            }

            @Bean
            public DIscountPolicy fixDiscountPolicy() {
                return new RateDiscountPolicy();
            }
        }
    }
}
