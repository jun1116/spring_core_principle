package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

//@Component 어노테이션이 붙은 클래스를 스캔해서 스프링빈으로 자동 등록해주는녀석
@Configuration
@ComponentScan(excludeFilters = @Filter(// 뺄거 지정
        type = FilterType.ANNOTATION,
        classes = Configuration.class) //Configuration붙은녀석을 뺄거야!
)
public class AutoAppConfig {
}
