package com.calculator.repository;

import com.calculator.domain.Student;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 16:47
 */
public interface StudentRepository extends CrudRepository<Student,Long> {

}
