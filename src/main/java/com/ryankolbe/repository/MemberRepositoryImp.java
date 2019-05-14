package com.ryankolbe.repository;

import com.ryankolbe.model.Member;

import java.util.HashSet;
import java.util.Set;

public class MemberRepositoryImp implements MemberRepository {
    private static MemberRepository memberRepository = null;
    private Set<Member> members;

    private MemberRepositoryImp() {
        this.members = new HashSet<>();
    }

    public static MemberRepository getMemberRepository() {
        if (memberRepository == null) memberRepository = new MemberRepositoryImp();
        return memberRepository;
    }

    @Override
    public Member create(Member member) {
        this.members.add(member);
        return member;
    }

    @Override
    public Member read(String memberId) {
        return search(memberId);
    }

    @Override
    public Member update(Member member) {
        Member memberTemp = search(member.getMemberId());
        if (memberTemp != null) {
            Member memberNew = new Member.Builder()
                    .copy(memberTemp)
                    .build();
            return memberNew;
        }
        return null;
    }

    @Override
    public void delete(String memberId) {
        Member deleteMember = search(memberId);
        if (deleteMember != null) this.members.remove(deleteMember);
    }

    @Override
    public Set<Member> getAll() {
        return this.members;
    }

    public Member search(final String memberId) {
        for (Member memberSearch : this.members) {
            if (memberSearch.getMemberId().equals(memberId))
                return memberSearch;
        }
        return null;
    }
}