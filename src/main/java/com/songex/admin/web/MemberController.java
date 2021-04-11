package com.songex.admin.web;

import com.songex.admin.service.MemberService;
import com.songex.admin.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    
    @GetMapping("/mainpage") // 메인 페이지
    public String mainPage() {
        return "songpro1/mainpage";
    }

    @GetMapping("/signup") //회원가입 페이지
    public String signUp() { 
        return "songpro1/signup"; 
    }

    @PostMapping("/signup") // 회원가입 처리
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);
        return "redirect:/login";
    }

    @GetMapping( "/loginn") // 로그인 페이지
    public String loginn() {
        return "songpro1/loginn"; 
    }
    
    // 로그인 결과 페이지, 로그아웃 결과 페이지는 추후 제작?
    
    @GetMapping("/errorpage") // 에러, 접근 거부 페이지
    public String errorPage() {
        return "songpro1/errorpage";
    }

    @GetMapping( "/memberdata") // 내 정보 페이지 -> /user/memberdata로 Role가 USER인 사용자만 들어갈 수 있게 따로 처리해야할 것 같은데?
    public String memberData() {
        return "songpro1/memberdata";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }
}

