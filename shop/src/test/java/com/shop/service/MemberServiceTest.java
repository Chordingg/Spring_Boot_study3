package com.shop.service;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Log4j2
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember() {
        MemberFormDto memberFormDTO = MemberFormDto.builder()
                .name("홍길동")
                .email("test@naver.com")
                .address("서울시 마포구")
                .password("1234")
                .build();
        return Member.createMember(memberFormDTO, passwordEncoder);
    }

    @Test
    @DisplayName("회원 가입 테스트")
    public void savaMemberTest(){
        Member member = createMember();

        Member savedMember = memberService.saveMember(member);
    }

    @Test
    @DisplayName("중복 가입 테스트")
    public void saveDuplicateMemberTest(){
        Member member = createMember();
        Member member2 = createMember();

        Member savedMember = memberService.saveMember(member);
        Member savedMember2 = memberService.saveMember(member2);
    }
}