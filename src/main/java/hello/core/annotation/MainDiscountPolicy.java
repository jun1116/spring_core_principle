package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;
//@Target({ElementType.CONSTRUCTOR, ElementType.METHOD,
//        ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
// TYPE , CONSTRUCTOR 의 차이가 있다...
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {}
