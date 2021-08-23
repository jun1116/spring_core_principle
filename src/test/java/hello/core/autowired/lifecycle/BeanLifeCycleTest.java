package hello.core.autowired.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class BeanLifeCycleTest {
    @Test
    public void LifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();}

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("IN CONFIG :: Spring__url.rurlrlrrjfl");
            return networkClient;
        }

//        @Scope("prototype")
//        @Component
//        public class HelloBean {
//        }
//
//        @Scope("prototype")
//        @Bean
//        PrototypeBean HelloBean(){
//            return new HelloBean();
//        }
    }
}
