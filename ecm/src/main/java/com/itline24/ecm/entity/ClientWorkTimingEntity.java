package com.itline24.ecm.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "client_work_timing", schema = "ecm_test", catalog = "")
public class ClientWorkTimingEntity {
    private int clientWorkTimingId;

    private String endTime;
    private String startTime;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private ClientEntity clientByClientId;

    @Id
    @Column(name = "client_work_timing_id")
    public int getClientWorkTimingId() {
        return clientWorkTimingId;
    }

    public void setClientWorkTimingId(int clientWorkTimingId) {
        this.clientWorkTimingId = clientWorkTimingId;
    }

    @Basic
    @Column(name = "end_time")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "start_time")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

        ClientWorkTimingEntity that = (ClientWorkTimingEntity) o;

        if (clientWorkTimingId != that.clientWorkTimingId) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientWorkTimingId;
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_Id" )
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
