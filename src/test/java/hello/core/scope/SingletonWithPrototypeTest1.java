package hello.core.scope;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {
    @Test
    void providerTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);
        System.out.println("count1 = " + count1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
        System.out.println("count2 = " + count2);
    }

    static class ClientBean{
        @Autowired
        private Provider<PrototypeBean> prototypeBeanObjectProvider;
//        아래 팩토리를 사용해도 괜찮아
//        private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;
        public int logic(){// 더하고, 꺼내서 반환
            PrototypeBean prototypeBean = prototypeBeanObjectProvider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }}
    @Scope("prototype")
    static class PrototypeBean{
        private int count=0;
        public void addCount(){this.count++;}
        public int getCount(){return this.count;}
        @PostConstruct public void init(){System.out.println("PrototypeBean.init : "+this);}
        @PreDestroy public void destroy(){System.out.println("PrototypeBean.destroy");}
    }}
