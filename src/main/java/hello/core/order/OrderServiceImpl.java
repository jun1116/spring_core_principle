package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService {

    /*
    * 현재 역할과 구현이 분리되었으며, 다형성활용 + 인터페이스와 구현객체 분리또한 잘 된것같다
    * 그러나,, OCP, DIP와 같은 객체지향설계원칙을 충실히 준수한듯하지만, 그렇지않다.
    * why?? -> OrderServiceImpl은 DiscountPolicy인터페이스에 의존하면서,
    * 구현클래스에도 의존하고있다.
    * 어떻게?
    * 위에 임포트하는것과 여기 밑에서 직접 받아서 사용하고있으니까!!
    * */
    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
        /*
        * 더이상 FixDiscountPolicy에 의존하지않음
        * OrderServiceImpl의 입장에서 생성자를통해 어떤 구현객체가 들어올지알수없음
        * 오직 AppConfig에서 결정, , 실행에만 집중하면됨*/
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice, discountPrice);
    }
}
