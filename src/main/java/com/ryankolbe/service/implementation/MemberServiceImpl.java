package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Member;
import com.ryankolbe.repository.MemberRepository;
import com.ryankolbe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member create(Member member) {
        return this.memberRepository.save(member);
    }

    @Override
    public Member read(String memberId) {
        Optional<Member> byId = this.memberRepository.findById(memberId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Member update(Member member) {
        return this.memberRepository.save(member);
    }

    @Override
    public void delete(String memberId) {
        this.memberRepository.deleteById(memberId);
    }

    @Override
    public List<Member> getAll() {
        return this.memberRepository.findAll();
    }
}