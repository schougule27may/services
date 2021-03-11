package com.itline24.ecm.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employee_resume", schema = "ecm_test", catalog = "")
public class EmployeeResumeEntity {
    private int empResumeId;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String shortDesc;
    private String data;
    private String fileLocation;
    private EmployeeEntity employeeByEmployeeId;

    @Id
    @Column(name = "emp_resume_id")
    public int getEmpResumeId() {
        return empResumeId;
    }

    public void setEmpResumeId(int empResumeId) {
        this.empResumeId = empResumeId;
    }

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

    @Basic
    @Column(name = "short_desc")
    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    @Basic
    @Column(name = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "file_location")
    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeResumeEntity that = (EmployeeResumeEntity) o;

        if (empResumeId != that.empResumeId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (shortDesc != null ? !shortDesc.equals(that.shortDesc) : that.shortDesc != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (fileLocation != null ? !fileLocation.equals(that.fileLocation) : that.fileLocation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empResumeId;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (shortDesc != null ? shortDesc.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (fileLocation != null ? fileLocation.hashCode() : 0);
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
}
