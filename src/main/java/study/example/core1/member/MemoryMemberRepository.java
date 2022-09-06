package study.example.core1.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // memoryMemberRepository로 Bean이 등록됨
public class MemoryMemberRepository implements MemberRepository{


    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findbyId(Long memberId) {
        return store.get(memberId);
    }
}
