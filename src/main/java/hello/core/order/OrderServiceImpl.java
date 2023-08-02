package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {


    //사용하는 필드가 2개임 memberRepository랑 DiscountPolicy
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //    private final DiscountPolicy discountPolicy = new FixDiscountPrice(); //고정할인금액
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  //DIP위반
    private final DiscountPolicy discountPolicy; //추상화에만 의존함

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
