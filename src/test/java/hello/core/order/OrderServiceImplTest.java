package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"가짜멤버", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "가짜아이템", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }
}