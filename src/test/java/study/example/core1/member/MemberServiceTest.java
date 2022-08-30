package study.example.core1.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.example.core1.Appconfig;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
    }

    @Test
    void join(){
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        memberService.join(member);
        Member findmember = memberService.findMember(1L);
        // then
        assertThat(member).isEqualTo(findmember);
    }
}
