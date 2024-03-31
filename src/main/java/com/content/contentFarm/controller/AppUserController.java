package com.content.contentFarm.controller;

import com.content.contentFarm.request.LoginRequest;
import com.content.contentFarm.service.AppUserService;
import com.content.dto.LoginResponseDto;
import com.content.dto.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;

@JBossLog
@RestController
@RequestMapping("app-user/")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/exist/{username}")
    public Mono<Result<Boolean>> isAppUsernameExist(@PathVariable("username") String username) {
        log.info("Happy");
       return appUserService.isUsernameExist(username)
               .map(isUsernameExist -> Result.successResult(isUsernameExist));
    }

    @PostMapping("/login")
    public Mono<Result<LoginResponseDto>> login(@RequestBody LoginRequest request) {
        log.info(MessageFormat.format("username: {0}", request.getUsername()));
        return appUserService.isUsernameExist(request.getUsername()).map(isExist -> isExist ? Result.successResult() : Result.failResult());
    }
}
