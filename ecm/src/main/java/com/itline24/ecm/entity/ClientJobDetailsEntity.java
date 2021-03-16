package com.itline24.ecm.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "client_job_details", schema = "ecm_test", catalog = "")
public class ClientJobDetailsEntity {
    private int jobDetailId;
    private String projectDetails;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private ClientEntity clientByClientId;

    @Id
    @Column(name = "job_detail_id")
    public int getJobDetailId() {
        return jobDetailId;
    }

    public void setJobDetailId(int jobDetailId) {
        this.jobDetailId = jobDetailId;
    }

    @Basic
    @Column(name = "project_details")
    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientJobDetailsEntity that = (ClientJobDetailsEntity) o;

        if (jobDetailId != that.jobDetailId) return false;
        if (projectDetails != null ? !projectDetails.equals(that.projectDetails) : that.projectDetails != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobDetailId;
        result = 31 * result + (projectDetails != null ? projectDetails.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
