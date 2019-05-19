package com.ryankolbe.factory;

import com.ryankolbe.domain.Member;

public class MemberFactory {
    public static Member createMember(String memberId, String memberName, String memberClass) {
        return new Member.Builder()
                .memberId(memberId)
                .memberName(memberName)
                .memberClass(memberClass)
                .build();
    }
}