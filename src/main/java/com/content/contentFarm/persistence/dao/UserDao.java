package com.content.contentFarm.persistence.dao;

import com.content.contentFarm.persistence.model.UserBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserDao extends ReactiveCrudRepository<UserBean, String> {
}
