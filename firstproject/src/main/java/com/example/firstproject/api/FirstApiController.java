package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI용 컨트롤러! JSON을 반환! 다른 것도 반환하긴 하지만 지금은 JSON
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world!";
    }
}
