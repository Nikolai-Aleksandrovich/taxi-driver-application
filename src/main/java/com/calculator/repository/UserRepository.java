package com.calculator.repository;

import com.calculator.domain.User;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 0:29
 */
public interface UserRepository extends CrudRepository<User, UUID> {
    User findByUsername(String name);

}
