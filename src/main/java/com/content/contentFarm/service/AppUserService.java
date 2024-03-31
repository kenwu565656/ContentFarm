package com.content.contentFarm.service;

import reactor.core.publisher.Mono;

public interface AppUserService {
    Mono<Boolean> isUsernameExist(String username);
}
