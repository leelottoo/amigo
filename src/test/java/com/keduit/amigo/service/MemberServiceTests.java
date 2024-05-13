package com.keduit.amigo.service;

import com.keduit.amigo.dto.MemberFormDTO;
import com.keduit.amigo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberServiceTests {

    @Autowired
    MemberService memberService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(){
        MemberFormDTO memberFormDTO = new MemberFormDTO();
        memberFormDTO.setNickname("로또");
        memberFormDTO.setEmail("ljelje8964@naver.com");
        memberFormDTO.setPassword("wlWldms89");
        return Member.createMember(memberFormDTO,passwordEncoder);
    }

    @Test
    public void saveMemberTest(){
        Member member = createMember();
        Member saveMember = memberService.saveMember(member);

        assertEquals(member.getNickname(),saveMember.getNickname());
        assertEquals(member.getEmail(),saveMember.getEmail());
        assertEquals(member.getPassword(),saveMember.getPassword());
    }
}
