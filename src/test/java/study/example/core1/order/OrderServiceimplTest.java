package study.example.core1.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.example.core1.discount.FixDiscountPolicy;
import study.example.core1.member.Grade;
import study.example.core1.member.Member;
import study.example.core1.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceimplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceimpl orderService = new OrderServiceimpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

}