package com.songex.admin.web;

import com.songex.admin.config.auth.Dto.SessionUser;
import com.songex.admin.config.auth.LoginUser;
import com.songex.admin.service.posts.PostsService;
import com.songex.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    
    @GetMapping("/")
    //public String index(Model model) { // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음, 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
    //    model.addAttribute("posts", postsService.findAllDesc());
        //SessionUser user = (SessionUser) httpSession.getAttribute("user"); // CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser 저장하도록 구성, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있음
    public String index(Model model, @LoginUser SessionUser user) { // 기존에 (User) httpSession.getAttribute("user")로 가져오던 세션 정보 값이 개선 되어 어느 컨트롤러든지 @LoginUser만 사용하면 세션 정보를 가져올 수 있게 됨
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) { // 세션에 저장된 값이 있을 때만 model에 userName으로 등록, 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태라 로그인 버튼이 보이게 됨
            model.addAttribute("userName", user.getName());
        }
        return "index"; // 머스테치 스타터로 앞의 경로는 src/main/resources/templates로, 뒤의 파일 확장자는 .mustache가 자동으로 붙음
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
