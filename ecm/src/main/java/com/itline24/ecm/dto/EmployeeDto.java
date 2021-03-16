package com.itline24.ecm.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Builder
public class EmployeeDto {
    private int employeeId;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private Boolean active;
    private Integer countryCode;
    private Integer mobile;
    private String address;
    private String nickName;
    private Boolean status;
    private String shortDesc;
    private String keyTechStack;
    private String autoExp;
    private String createTimeStr;
    private String lastUpdateTimeStr;

}
