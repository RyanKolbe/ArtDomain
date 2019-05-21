package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Member;
import com.ryankolbe.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("MemberRepository")
public class MemberRepositoryImpl implements MemberRepository {
    private static MemberRepositoryImpl memberRepository = null;
    private Set<Member> members;


    private MemberRepositoryImpl() {
        this.members = new HashSet<>();
    }

    public static MemberRepositoryImpl getMemberRepository() {
        if (memberRepository == null) memberRepository = new MemberRepositoryImpl();
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
            return create(new Member.Builder()
                    .copy(memberTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String memberId) {
        Member memberDelete = search(memberId);
        if (memberDelete != null) this.members.remove(memberDelete);
    }

    private Member search(final String memberId) {
        for (Member memberSearch : this.members) {
            if (memberSearch.getMemberId().equals(memberId))
                return memberSearch;
        }
        return null;
    }

    @Override
    public Set<Member> getAll() {
        return this.members;
    }
}