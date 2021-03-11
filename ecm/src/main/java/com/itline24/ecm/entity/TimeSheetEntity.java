
package com.itline24.ecm.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "time_sheet", schema = "ecm_test", catalog = "")
public class TimeSheetEntity {
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private int timeSheetId;
    private Integer noOfHours;
    private String detailsEod;
    private String status;
    private EmployeeEntity employeeByEmployeeId;
    private ClientEntity clientByClientId;

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_update_time")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Id
    @Column(name = "time_sheet_id")
    public int getTimeSheetId() {
        return timeSheetId;
    }

    public void setTimeSheetId(int timeSheetId) {
        this.timeSheetId = timeSheetId;
    }




    @Basic
    @Column(name = "no_of_hours")
    public Integer getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Integer noOfHours) {
        this.noOfHours = noOfHours;
    }

    @Basic
    @Column(name = "details_eod")
    public String getDetailsEod() {
        return detailsEod;
    }

    public void setDetailsEod(String detailsEod) {
        this.detailsEod = detailsEod;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSheetEntity that = (TimeSheetEntity) o;

        if (timeSheetId != that.timeSheetId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (noOfHours != null ? !noOfHours.equals(that.noOfHours) : that.noOfHours != null) return false;
        if (detailsEod != null ? !detailsEod.equals(that.detailsEod) : that.detailsEod != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = createTime != null ? createTime.hashCode() : 0;
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + timeSheetId;
        result = 31 * result + (noOfHours != null ? noOfHours.hashCode() : 0);
        result = 31 * result + (detailsEod != null ? detailsEod.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_Id")
    public EmployeeEntity getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_Id")
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
