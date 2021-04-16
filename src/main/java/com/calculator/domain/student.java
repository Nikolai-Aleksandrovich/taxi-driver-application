package com.calculator.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Yuyuan Huang
 * @create 2021-04-14 11:18
 */
@Data
@RestResource(rel = "students",path = "students")
@Document
public class student {
    @Id
    private String id;
    @NotNull(message = "请填写姓名")
    private String name;

    private Date createdAt = new Date();

    private final String admitYear;
    private final Component.IdentityType identityType;
    private final String certificatesRegisterDate;
    //产证登记时间
    private final String childrenRegisterInQingDaoDate;
    //儿童落户时间
    private final boolean isParentsSharePropertyRights100%;
    //父母是否共有产权
    private final boolean isLocalAndMoreThanAYear;
    //父母在高新区是否一年以上且户籍在高新区
    private final boolean isSecondWaveOutSiderWorker;
    //是否为第二批外来务工人员
    private final String timeOfPayingSocialSecurity;
    //第二批外来务工人员缴纳社保时间
    private final String timeOfHavingResidencePermit;
    //第二批外来务工人员持有居住证时间
    private final boolean isServiceWorkerLiveInSameDistrictAYear;
    //第二批服务工住同区满一年
    private final EducationalBackground EducationalBackground;
    public static enum EducationalBackground{
        PhD,masterDegree,
    }

    


}
