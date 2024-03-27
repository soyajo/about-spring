package com.soyajo.aboutspring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 역할과 구현을 둘 다 의존 한다. 추상화, 구현 부분 - DIP 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();


    /**
     * AppConfig 쪽에서  구현 객체를 생성
     * 생성자 주입
     */
    private final MemberRepository memberRepository;

    /**
     * 의존관계 자동 생성자 주입
     * @param memberRepository
     */
    @Autowired
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

    // test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
