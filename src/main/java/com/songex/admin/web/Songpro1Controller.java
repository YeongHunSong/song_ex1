package com.songex.admin.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class Songpro1Controller {

    @GetMapping("/mainpage")
    public String songpro1() {return "songpro1/mainpage"; }
}
