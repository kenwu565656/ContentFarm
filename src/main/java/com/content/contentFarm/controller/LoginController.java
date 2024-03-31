package com.content.contentFarm.controller;

//import com.content.contentFarm.dto.LoginResponseDto;

import com.content.contentFarm.request.LoginRequest;
import com.content.contentFarm.service.UserService;
import com.content.dto.LoginResponseDto;
import com.content.dto.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;

@JBossLog
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/login")
    public Result<LoginResponseDto> login(@RequestBody LoginRequest request) {
        log.info(MessageFormat.format("username: {0}", request.getUsername()));
        if (request.getUsername().equals("hello")) {
            return Result.successResult();
        } else {
            return Result.failResult();
        }
    }

    @PostMapping("/login2")
    public Mono<Result<LoginResponseDto>> login2(@RequestBody LoginRequest request) {
        log.info(MessageFormat.format("username: {0}", request.getUsername()));
        return userService.isUserExist(request.getUsername()).map(isExist -> isExist ? Result.successResult() : Result.failResult());
    }
}
