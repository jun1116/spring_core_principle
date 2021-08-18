package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* ApplicationContext를 스프링 컨테이너라고 한다.
* 기존에는 개발자가 AppConfig를 사용해서 직접 객체를 생성하고, DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.
* 스프링 컨테이너는 @Configuration이 붙은 AppConfig를 설정(구성)정보로 사용한다.
* 여기서 @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링컨테이너에 등록한다.
* 이렇게 등록된 객체를 스프링빈 이라고 한다.
* 이전에는 개발자가 필요한 객체를 AppConfig를 사용해서 직접 조회했지만, 이제부터는
* 스프링컨테이너를 통해 필요한 스프링빈(객체)를 찾아야한다.
* 스프링빈은 applicationContext.getBean()이라는 메서드를 사용해서 찾을 수 있다
* 기존에는 개발자가 직접 자바코드로 모든 것을 했다면.. 이제는 스프링컨테이너에 객체를 스프링빈으로 등록하고
* 스프링 컨테이너에서 스프링빈을 찾아서 사용하도록 변경되었다.
* */

@Configuration //설정을 구성한다는 뜻의 어노테이션
public class AppConfig {
    @Bean // 스프링컨테이너에 스프링빈으로 등록
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl( memberRepository(), discountPolicy() );
//        return new OrderServiceImpl();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
