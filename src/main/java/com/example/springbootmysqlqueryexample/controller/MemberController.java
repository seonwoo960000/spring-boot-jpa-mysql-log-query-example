package com.example.springbootmysqlqueryexample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmysqlqueryexample.entity.MemberEntity;
import com.example.springbootmysqlqueryexample.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("members")
    public List<MemberEntity> findAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("members/{id}")
    public MemberEntity findById(@PathVariable Long id) {
        return memberRepository.findById(id)
                               .orElse(null);
    }

    @PostMapping("members")
    public MemberEntity save(@RequestParam String username,
                             @RequestParam String name) {
        return memberRepository.save(MemberEntity.builder()
                                                 .username(username)
                                                 .name(name)
                                                 .build());
    }

    @PostMapping("members2")
    public void saveWithDifferentIsolationLevel(@RequestParam String username,
                                                        @RequestParam String name) {
        memberRepository.saveWithDifferentIsolationLevel(username, name);
    }
}
