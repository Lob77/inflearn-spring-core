package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService" , MemberService.class);
        Assertions.assertInstanceOf(MemberService.class,memberService);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberService.class,memberService);
    }
    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService" , MemberServiceImpl.class);
        Assertions.assertInstanceOf(MemberService.class,memberService);
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNamex(){
        //ac.getBean("xxxxxx", MemberService.class);
        //MemberService memberService = ac.getBean("xxxxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,() -> ac.getBean("xxxxxx", MemberService.class));
    }
}
