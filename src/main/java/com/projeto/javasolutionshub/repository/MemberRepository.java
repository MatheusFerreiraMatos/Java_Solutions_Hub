package com.projeto.javasolutionshub.repository;

import com.projeto.javasolutionshub.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
