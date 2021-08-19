package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

//        MemberService memberService = ac.getBean("memberService",MemberService.class); //왜 이름을 붙여서 찾으면 에러가날까?
        MemberService memberService = ac.getBean(MemberService.class);
//        OrderService orderService = ac.getBean("orderService", OrderService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
