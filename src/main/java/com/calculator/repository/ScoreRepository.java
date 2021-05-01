package com.calculator.repository;

import com.calculator.domain.Score;
import com.calculator.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;


/**
 * @author Yuyuan Huang
 * @create 2021-04-26 23:23
 */

public interface ScoreRepository extends CrudRepository<Score,Long> {

}
