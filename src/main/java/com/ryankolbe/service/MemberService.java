package com.ryankolbe.service;

import com.ryankolbe.domain.Member;

import java.util.List;

public interface MemberService extends IService<Member, String> {
    List<Member> getAll();
}