package com.content.contentFarm.persistence.dao;

import com.content.contentFarm.persistence.model.AppUserBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppUserDao extends ReactiveCrudRepository<AppUserBean, String> {
    Flux<AppUserBean> findByUsername(String username);
}
