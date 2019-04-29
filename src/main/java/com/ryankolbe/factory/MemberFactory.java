package com.ryankolbe.factory;

import com.ryankolbe.model.Address;
import com.ryankolbe.model.Locality;
import com.ryankolbe.model.Member;
import com.ryankolbe.model.User;
import com.ryankolbe.util.Misc;

public class MemberFactory {

    public static Member createMember(User user, Address address, Locality locality) {
        return new Member.Builder()
                .memberId(Misc.generateId())
                .user(user)
                .address(address)
                .locality(locality)
                .build();
    }
}