package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//import java.util.concurrent.ConcurrentHashMap;
@Component
public class MemoryMemberRepository implements MemberRepository{
//  동시성이슈
//    private static ConcurrentHashMap<Long, Member> store = new ConcurrentHashMap<>();
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
