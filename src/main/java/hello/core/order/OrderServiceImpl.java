package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository ; //final이 붙어있으면, 이 값에 null이 들어갈 수 없어.
    private final DiscountPolicy discountPolicy ;

///*  Lombok의 @RequiredArgsConstructor 적용으로, 생성자 안써도 자동으로생겨!
    @Autowired //생략해도 생성자가 하나일땐 이건 자동으로 오토와이어드됨
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    } //*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice, discountPrice);
    }
    //Test 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
