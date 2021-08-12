package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    /*각 테스트 실행 전 호출*/
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        //생성한것과
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        //그것을 찾았을 때,

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        // 잘 찾아지는가?
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
