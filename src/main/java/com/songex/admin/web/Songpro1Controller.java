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

    @GetMapping("/signup")
    public String signUp() {
        return "songpro1/signup";
    }
}
