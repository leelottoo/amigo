package com.keduit.amigo.controller;

import com.keduit.amigo.dto.MemberFormDTO;
import com.keduit.amigo.entity.Member;
import com.keduit.amigo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
//@Transactional
public class MemberControllerTests {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember(String email, String password){
        MemberFormDTO memberFormDTO = new MemberFormDTO();
        memberFormDTO.setNickname("유저");
        memberFormDTO.setEmail(email);
        memberFormDTO.setPassword(password);
        Member member = Member.createMember(memberFormDTO,passwordEncoder);
        System.out.println("member--------->" + member);
        return memberService.saveMember(member);
    }

    @Test
    public void loginSuccessTest() throws Exception{
        String email = "user8888@naver.com";
        String password = "12345678";
        this.createMember(email,password);
        mockMvc.perform(formLogin().userParameter("email")
                .loginProcessingUrl("/members/login")
                .user(email).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }
}
