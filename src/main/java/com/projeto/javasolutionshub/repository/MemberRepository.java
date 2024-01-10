package com.projeto.javasolutionshub.repository;

import com.projeto.javasolutionshub.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface MemberRepository extends JpaRepository<Member, Long> {
    UserDetails findByUsername(String username);

}
