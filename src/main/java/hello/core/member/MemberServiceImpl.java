package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memeMemberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memeMemberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memeMemberRepository.findById(memberId);
    }
}
