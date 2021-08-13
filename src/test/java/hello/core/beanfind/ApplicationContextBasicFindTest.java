package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
//            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
//                Object bean = ac.getBean(beanDefinitionName);
//                System.out.println("name = " + beanDefinitionName + " Object = "+bean);
//            }
//        }
    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType_WithoutName() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByType() {
        //이건 별로 좋지는 않아 (구현에 의존한 형태이므로)
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈이름으로 조회 XX")
    void findBeanByNameX() {
        /*
        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
//org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'xxxxx' available
         */
        
        //무조건 NoSuch~~예외가 터져야 로직이 성공하는 코드
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, //앞의 에러가 터져야 성공이야
                () -> ac.getBean("xxxxx", MemberService.class) //이걸 실행했을 때
        );
    }
}