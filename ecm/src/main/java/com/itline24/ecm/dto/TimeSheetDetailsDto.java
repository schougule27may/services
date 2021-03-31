package com.itline24.ecm.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Builder
@Data
public class TimeSheetDetailsDto {

    private int timeSheetId;
    private Integer noOfHours;
    private String detailsEod;
    private String status;
    private Integer employeeId;
    private Integer clientId;
    private String employeeName;

    @Tolerate
    public TimeSheetDetailsDto(){

    }

}
