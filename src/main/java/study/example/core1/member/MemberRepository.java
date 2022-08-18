package study.example.core1.member;

public interface MemberRepository {

    void save(Member member);

    Member findbyId(Long memberId);
}
