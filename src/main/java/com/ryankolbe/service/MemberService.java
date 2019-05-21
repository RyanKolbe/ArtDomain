package com.ryankolbe.service;

import com.ryankolbe.domain.Member;

import java.util.Set;

public interface MemberService extends IService<Member, String> {
    Set<Member> getAll();
}