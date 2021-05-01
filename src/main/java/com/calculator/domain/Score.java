package com.calculator.domain;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Yuyuan Huang
 * @create 2021-05-01 0:55
 */
@Entity
@Data
@RestResource(rel = "scores",path = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String studentId;
    private final String score;
}
