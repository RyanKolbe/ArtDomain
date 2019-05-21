package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Member;
import com.ryankolbe.repository.MemberRepository;
import com.ryankolbe.repository.implementation.MemberRepositoryImpl;
import com.ryankolbe.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    private MemberServiceImpl() {
        this.memberRepository = MemberRepositoryImpl.getMemberRepository();
    }

    @Override
    public Set<Member> getAll() {
        return this.memberRepository.getAll();
    }

    @Override
    public Member create(Member member) {
        return this.memberRepository.create(member);
    }

    @Override
    public Member read(String memberId) {
        return this.memberRepository.read(memberId);
    }

    @Override
    public Member update(Member member) {
        return this.memberRepository.update(member);
    }

    @Override
    public void delete(String memberId) {
        this.memberRepository.delete(memberId);
    }
}