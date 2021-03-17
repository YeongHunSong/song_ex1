package com.songex.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // 머스테치 스타터로 앞의 경로는 src/main/resources/templates로, 뒤의 파일 확장자는 .mustache가 자동으로 붙음
    }
}
