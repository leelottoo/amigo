package com.keduit.amigo.service;

import com.keduit.amigo.dto.MemberFormDTO;
import com.keduit.amigo.entity.Member;
import com.keduit.amigo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) { /* (MemberFormDTO memberFormDTO) 로 변경 해줘야함 */
        validateDuplicateMember(member); // 중복체크
        System.out.println("여기도 갔다.");
        return memberRepository.save(member);
    }
    private void validateDuplicateMember(Member member){
        Member findmember = memberRepository.findByEmail(member.getEmail());
        if(findmember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

//      시큐리티 없을 때
//    private Member convertToMember(MemberFormDTO memberFormDTO) {
//
//        Member member = new Member();
//        member.setEmail(memberFormDTO.getEmail());
//        member.setPwd(memberFormDTO.getPwd());
//        member.setUsername(memberFormDTO.getUsername());
//        System.out.println("가지고 왔다");
//        return member;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles("user") //admin추가하면 추가
                .build();
    }


//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
//        Member member = memberRepository.findByEmail(email);
//
//        if(member == null){
//            throw new UsernameNotFoundException(email);
//        }
//        return User.builder()
//                .username(member.getEmail())
//                .password(member.getPwd())
//                .build();
//    }

}
