package com.itline24.ecm.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.sql.Timestamp;

@Builder
@Data
public class MasterRatesDto {
    private int masterRatesId;
    private String type;
    private Double amount;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;

    @Tolerate
    public MasterRatesDto() {

    }
}
