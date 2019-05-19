package com.ryankolbe.factory;

import com.ryankolbe.domain.Member;
import org.junit.Assert;
import org.junit.Test;

public class MemberFactoryTest {

    @Test
    public void createMember() {
        Member member = MemberFactory.createMember("0001", "Ryan", "Gold");
        Assert.assertEquals("Gold", member.getMemberClass());
    }
}