package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //    private final MemberRepository memeMemberRepository = new MemoryMemberRepository();
    private final MemberRepository memeMemberRepository;

    //생성자를 통해서 memberRepository의 구현체 결정
    public MemberServiceImpl(MemberRepository memeMemberRepository) {
        this.memeMemberRepository = memeMemberRepository;
    }


    @Override
    public void join(Member member) {
        memeMemberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memeMemberRepository.findById(memberId);
    }
}
