package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
// Member는 스프링 빈이 아니다.
    static class TestBean{
        @Autowired(required = false) // true이면 바로 예외터짐
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }//의존관계가 없으면 이 메서드 자체가 호출되지않아

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }//호출은 되는데, null로 들어가

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }//자바8 Optional문법
    }
}
