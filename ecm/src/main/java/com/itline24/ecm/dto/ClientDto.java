package com.itline24.ecm.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.sql.Timestamp;

@Builder
@Data
public class ClientDto {

    private int clientId;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private Boolean active;
    private Integer countryCode;
    private Integer mobile;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String address;
    private String nickName;
    private String type;
    @Tolerate
    public ClientDto(){

    }
}
