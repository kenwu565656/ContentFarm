package com.content.contentFarm.service.impl;

import com.content.contentFarm.persistence.dao.UserDao;
import com.content.contentFarm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public Mono<Boolean> isUserExist(String username) {
        return userDao.existsById(username);
    }
}
