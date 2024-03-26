package com.soyajo.aboutspring.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
