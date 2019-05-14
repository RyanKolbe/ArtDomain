package com.ryankolbe.repository;

import com.ryankolbe.factory.*;
import com.ryankolbe.model.Member;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberRepositoryImpTest {
    private static MemberRepository memberRepository = MemberRepositoryImp.getMemberRepository();
    private static Member member;
    private static Set<Member> members = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        member = MemberFactory.createMember(
                UserFactory.createUser(LoginFactory.createLogin("Ryan", "Pass.123"),
                        RoleFactory.createRole("Administrator", "Administers Accounts"),
                        PermissionFactory.createPermission("Administrator", "System Admin",
                                "Admin", "System Administrator"),
                        NameFactory.createName("Ryan", "Fabian", "Kolbe"),
                        ContactFactory.createContact("0219597000", "Landline",
                                "ryank@gmail.com")),
                AddressFactory.createAddress("10", "Trumpet", "Street"),
                LocalityFactory.createLocality("Steenberg", "Western Cape", "South Africa",
                        "7946"));
    }

    @Test
    public void create() {
        members.add(memberRepository.create(member));
        Assert.assertEquals(member.getMemberId(), Objects.requireNonNull(memberRepository
                .getAll()
                .stream()
                .findFirst()
                .orElse(null))
                .getMemberId());
    }

    @Test
    public void read() {
        members.add(memberRepository.create(member));
        Member readMember = memberRepository.read(members.iterator().next().getMemberId());
        Assert.assertEquals(readMember, memberRepository.read(readMember.getMemberId()));
    }

    @Test
    public void update() {
        members.add(memberRepository.create(member));
        String newMemberID = Misc.generateId();
        Member memberUpdate = new Member.Builder().copy(member).memberId(newMemberID).build();
        Assert.assertEquals(newMemberID, memberUpdate.getMemberId());
    }

    @Test
    public void delete() {
        members.add(memberRepository.create(member));
        memberRepository.delete(members.iterator().next().getMemberId());
        members.remove(member);
        Assert.assertEquals(members.size(), memberRepository.getAll().size());
    }

    @Test
    public void getAll() {
        members.add(memberRepository.create(member));
        Set<Member> members = memberRepository.getAll();
        Assert.assertEquals(members, memberRepository.getAll());
    }
}