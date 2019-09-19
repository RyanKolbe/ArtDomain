package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Member;
import com.ryankolbe.factory.MemberFactory;
import com.ryankolbe.service.MemberService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberServiceImplTest {
    @Autowired
    @Qualifier("MemberServiceImpl")
    private MemberService memberService;
    private Member member;
    private Set<Member> members = new HashSet<>();

    @Before
    public void setUp() {
        member = memberService.create(MemberFactory.createMember("0001", "Deidre",
                "Gold"));
        members.add(member);
    }

    @Test
    public void create() {
        Member createMember = memberService.create(MemberFactory.createMember("0005", "Rhea",
                "Platinum"));
        members.add(createMember);
        Assert.assertEquals(createMember, memberService.read(createMember.getMemberId()));
    }

    @Test
    public void read() {
        Member readMember = memberService.read(member.getMemberId());
        Assert.assertEquals(readMember, memberService.read(readMember.getMemberId()));
    }

    @Test
    public void update() {
        String newMemberName = "Cassidy";
        Member updateMember = memberService.update(new Member.Builder().copy(member)
                .memberName(newMemberName).build());
        members.add(updateMember);
        Assert.assertEquals(updateMember, memberService.read(updateMember.getMemberId()));
    }

    @Test
    public void delete() {
        members.addAll(memberService.getAll());
        Member deleteMember = memberService.create(MemberFactory.createMember("0005", "Ronnel",
                "Silver"));
        members.add(deleteMember);
        members.remove(deleteMember);
        memberService.delete(deleteMember.getMemberId());
        Assert.assertEquals(members.size(), memberService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Member> memberSet = memberService.getAll();
        Assert.assertEquals(memberSet.size(), memberService.getAll().size());
    }
}