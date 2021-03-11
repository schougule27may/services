package com.itline24.ecm.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "client_rates", schema = "ecm_test", catalog = "")
public class ClientRatesEntity {
    private int clientRatesId;
    private String type;
    private Double amount;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private Integer clientId;

    @Id
    @Column(name = "client_rates_id")
    public int getClientRatesId() {
        return clientRatesId;
    }

    public void setClientRatesId(int clientRatesId) {
        this.clientRatesId = clientRatesId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
    @Column(name = "client_id")
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientRatesEntity that = (ClientRatesEntity) o;

        if (clientRatesId != that.clientRatesId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientRatesId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }
}
