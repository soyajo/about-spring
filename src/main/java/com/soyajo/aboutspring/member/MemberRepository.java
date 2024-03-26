package com.soyajo.aboutspring.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
