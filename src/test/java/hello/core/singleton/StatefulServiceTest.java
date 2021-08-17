package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import hello.core.singleton.StatefulService;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // A 사용자 10000원 주문
        int userA_price = statefulService1.order("userA", 10000);
        // B 사용자 20000원 주문
        int userB_price = statefulService2.order("userB", 20000);

        //ThreadA : 사용자 A주문금액 조회
//        int price1 = statefulService1.getPrice();
//        int price2 = statefulService2.getPrice();
//        System.out.println("TEST - price1 = " + price1);
//        System.out.println("TEST - price2 = " + price2);
        System.out.println("userA_price = " + userA_price);
        System.out.println("userB_price = " + userB_price);
    }

//    @Configuration
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
//    static class TestConfig{
//        @Bean
//        public StatefulService statefulService(){
//            return new StatefulService();
//        }
//    }
//}
