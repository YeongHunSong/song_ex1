package com.songex.admin.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴 스프링 부트 테스트와 JUnit사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) // Spring MVC에 집중할 수 있는 어노테이션으로 @Controller, @ControllerAdvice 등을 사용할 수 있음
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입 받음
    private MockMvc mvc; // 웹 API를 테스트할 때 사용 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함
            .andExpect(status().isOk()) // mvc.preform의 결과를 검증함 / 200, 404, 500 등의 상태를 검증하고 여기서는 OK 즉, 200인지 아닌지를 검증
            .andExpect(content().string(hello)); // mvc.preform의 결과를 검증 / 응답 본문의 내용을 검증 hello를 리턴하는지, 이 값이 맞는지 검증
    }
}

