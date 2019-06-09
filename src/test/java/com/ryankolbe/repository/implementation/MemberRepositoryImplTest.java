package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Member;
import com.ryankolbe.factory.MemberFactory;
import com.ryankolbe.repository.MemberRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberRepositoryImplTest {
    private static MemberRepository memberRepository = MemberRepositoryImpl.getMemberRepository();
    private static Member member;
    private static Set<Member> members = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        member = MemberFactory.createMember("0001", "Deidre", "Gold");
        members.add(memberRepository.create(member));
    }

    @Test
    public void getMemberRepository() {
        Assert.assertNotNull(memberRepository);
    }

    @Test
    public void create() {
        Member createMember = MemberFactory.createMember("0002", "Cassidy", "Platinum");
        members.add(memberRepository.create(createMember));
        Assert.assertEquals(createMember, memberRepository.read(createMember.getMemberId()));
    }

    @Test
    public void read() {
        Member readMember = memberRepository.read(member.getMemberId());
        Assert.assertEquals(readMember, memberRepository.read(readMember.getMemberId()));
    }

    @Test
    public void update() {
        String newMemberName = "Rhea";
        Member updateMember = new Member.Builder().copy(member).memberName(newMemberName).build();
        members.add(memberRepository.update(updateMember));
        Assert.assertEquals(updateMember, memberRepository.read(updateMember.getMemberId()));
    }

    @Test
    public void delete() {
        Member deleteMember = MemberFactory.createMember("0046", "Ronnel", "Silver");
        members.add(memberRepository.create(deleteMember));
        members.remove(deleteMember);
        memberRepository.delete(deleteMember.getMemberId());
        Assert.assertEquals(members.size(), memberRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Member> memberSet = memberRepository.getAll();
        Assert.assertEquals(memberSet.size(), memberRepository.getAll().size());
    }
}