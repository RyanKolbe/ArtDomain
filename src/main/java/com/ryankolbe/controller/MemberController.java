package com.ryankolbe.controller;

import com.ryankolbe.domain.Member;
import com.ryankolbe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    @ResponseBody
    public Member create(@RequestBody Member member) {
        return memberService.create(member);
    }

    @PutMapping("/update")
    @ResponseBody
    public Member update(@RequestBody Member member) {
        return memberService.update(member);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Member read(@PathVariable String id) {
        return memberService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Member> getAll() {
        return memberService.getAll();
    }
}