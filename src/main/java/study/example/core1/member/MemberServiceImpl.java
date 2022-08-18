package study.example.core1.member;

public class MemberServiceImpl implements memberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findbyId(memberId);
    }
}
