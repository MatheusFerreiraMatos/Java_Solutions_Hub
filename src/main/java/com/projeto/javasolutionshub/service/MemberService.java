package com.projeto.javasolutionshub.service;

import com.projeto.javasolutionshub.entity.Member;
import com.projeto.javasolutionshub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public Member getMember(String username) {
        return (Member) repository.findByUsername(username);
    }
}
