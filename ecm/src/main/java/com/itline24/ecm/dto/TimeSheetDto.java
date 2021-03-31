
package com.itline24.ecm.dto;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Builder
@Data
public class TimeSheetDto {

    private int timeSheetId;
    private Integer noOfHours;
    private String detailsEod;
    private String status;
    private Integer employeeId;
    private Integer clientId;

    public int getTimeSheetId() {
        return timeSheetId;
    }

    public void setTimeSheetId(int timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

    public Integer getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Integer noOfHours) {
        this.noOfHours = noOfHours;
    }

    public String getDetailsEod() {
        return detailsEod;
    }

    public void setDetailsEod(String detailsEod) {
        this.detailsEod = detailsEod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Tolerate
    public TimeSheetDto(){

    }
}
