package com.calculator.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Yuyuan Huang
 * @create 2021-04-13 16:27
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Document
public class Component {
    @Id
    private final String id;
    private final String name;
    private final String admitYear;
    private final IdentityType identityType;
    private final String certificatesRegisterTime;


    public static enum IdentityType{
        TwoCertificatesAreComplete,MigrantWorkers
    }
}
