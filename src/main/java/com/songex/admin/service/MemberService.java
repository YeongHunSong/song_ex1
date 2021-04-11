package com.songex.admin.service;

import com.songex.admin.domain.MemberEntity;
import com.songex.admin.domain.MemberRepository;
import com.songex.admin.domain.Role_songpro;
import com.songex.admin.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser (MemberDto memberDto) { // 회원가입을 처리하는 메서드로 비밀번호를 암호화하여 저장
        //비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getMemberNumber();
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { // 상세 정보를 조회하는 메서드, 사용자의 계정정보와 권한을 갖는 UserDetails 인터페이스를 반환해야 함, 매개변수는 로그인 시 입력한 아이디인데 인티티의 PK를 뜻하는 것이 아닌 유저를 식별할 수 있는 어떤 값을 의미함 Spring Security에서는 username라는 이름으로 사용
        Optional<MemberEntity> userEntityWrapper = memberRepository.findById(userId);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("car0628").equals(userId)) {
            authorities.add(new SimpleGrantedAuthority(Role_songpro.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role_songpro.MEMBER.getValue()));
        }

        return new User(userEntity.getId(), userEntity.getPassword(), authorities); // return은 SpringSecurity에서 제공하는 UserDetails를 구현한 User를 반환함 (org.springframework.security.core.userdetails.User), 생성자의 각 매개변수는 순서대로 아이디, 비밀번호, 권한리스트임
    }
}
