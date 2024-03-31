package com.content.contentFarm.service;

import reactor.core.publisher.Mono;

public interface UserService {
    Mono<Boolean> isUserExist(String username);
}
