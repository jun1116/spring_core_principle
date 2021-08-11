package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //    앞에있는건 인터페이스 , 뒤에있는건 구현체
    // 그 이유는 memberRepository가 Null Point Exception이 터져서
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
