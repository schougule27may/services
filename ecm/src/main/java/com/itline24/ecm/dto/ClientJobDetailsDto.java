package com.itline24.ecm.dto;

import com.itline24.ecm.entity.ClientEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.sql.Timestamp;

@Data
@Builder
public class ClientJobDetailsDto {
    private int jobDetailId;
    private String projectDetails;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private ClientEntity clientByClientId;

    @Tolerate
    public ClientJobDetailsDto(){

    }
}
