package com.ryankolbe.controller;

import com.ryankolbe.domain.Member;
import com.ryankolbe.service.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(@Qualifier("MemberServiceImpl") MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Member create(@RequestBody Member member) {
        return memberService.create(member);
    }

    @PostMapping("/update")
    @ResponseBody
    public Member update(@RequestBody Member member) {
        return memberService.update(member);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Member read(@PathVariable String id) {
        return memberService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Member> getAll() {
        return memberService.getAll();
    }
}