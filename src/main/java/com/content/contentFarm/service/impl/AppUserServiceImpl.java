package com.content.contentFarm.service.impl;

import com.content.contentFarm.persistence.dao.AppUserDao;
import com.content.contentFarm.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDao appUserDao;

    @Override
    public Mono<Boolean> isUsernameExist(String username) {
        return appUserDao.findByUsername(username).hasElements();
    }
}
