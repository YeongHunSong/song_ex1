package com.songex.admin.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class Songpro1Controller {

    @GetMapping("/mainpage")
    public String mainPage() {
        return "songpro1/mainpage";
    }

    @GetMapping( "/mainpage-login")
    public String mainPage_Login() {
        return "songpro1/mainpage-login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "songpro1/signup";
    }

    @GetMapping( "/memberdata")
    public String memberData() {
        return "songpro1/memberdata";
    }

    @GetMapping( "/loginn")
    public String loginn() {
        return "songpro1/loginn";
    }

    @GetMapping( "/category")
    public String category() {
        return "songpro1/category";
    }

    @GetMapping( "/myreply")
    public String myReply() {
        return "songpro1/myreply";
    }

    @GetMapping( "/mytext")
    public String myText() {
        return "songpro1/mytext";
    }

    @GetMapping( "/postdetail")
    public String postDetail() {
        return "songpro1/postdetail";
    }

    @GetMapping( "/searchid")
    public String searchId() {
        return "songpro1/search-id";
    }

    @GetMapping( "/searchpw")
    public String searchPw() {
        return "songpro1/search-pw";
    }

    @GetMapping( "/searchresult")
    public String searchResult() {
        return "songpro1/search-result";
    }
}
