package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPrice;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository()); //단축키 ctrl+alt+m
    }

    private static MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPrice(); //shift+f10 마지막 실행했던게 실행됨
//        return new RateDiscountPolicy();
    }

}
