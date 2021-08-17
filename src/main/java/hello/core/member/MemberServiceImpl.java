package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //    앞에있는건 인터페이스 , 뒤에있는건 구현체
    // 그 이유는 memberRepository가 Null Point Exception이 터져서
    private final MemberRepository memberRepository ;

    /*MemberServiceImpl에 생성자 주입
    이로써 MemoryMemberRepository를 의존하지않고, 단지 MemoryRepository 인터페이스만 의존하게됨
    MemberServiceImpl 입장에서는 생성자를 통해 어떤 구현객체가 주입될지 알수없음
    그것은 오직 외부(AppConfig)에서 결정
    의존관계는 외부에 맡기고, 실행에만 집중하면됨
    */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
