package study.example.core1.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberREposiotry.class)와 유사한 기능
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }


    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findbyId(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
