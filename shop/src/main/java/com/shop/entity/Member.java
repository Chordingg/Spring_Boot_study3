package com.shop.entity;

import com.shop.constant.Role;
import com.shop.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity // 클래스를 엔티티로 선언
@Table(name = "member")   // 엔티티와 매팅할 테이블을 지정(테이블명 지정)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)
    //@Enumerated(EnumType.ORDINAL)
    private Role role;


    // 이거 대신 Mapper 란 것을 이용할 수도 있음
    public static Member createMember(MemberFormDto memberFormDTO, PasswordEncoder passwordEncoder) {

        Member member = Member.builder()
                .name(memberFormDTO.getName())
                .email(memberFormDTO.getEmail())
                .phone(memberFormDTO.getPhone())
                .address(memberFormDTO.getAddress())
                .password(passwordEncoder.encode(memberFormDTO.getPassword())) // 암호화 해야됨, 안하면 DB에 값이 안들어감
                .role(Role.USER)
                .build();

        return member;
    }
}
