package com.itline24.ecm.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "client", schema = "ecm_test", catalog = "")
public class ClientEntity {
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
    private Collection<ClientJobDetailsEntity> clientJobDetailsByClientId;
    private Collection<ClientWorkTimingEntity> clientWorkTimingsByClientId;
    private Collection<TimeSheetEntity> timeSheetsByClientId;

    @Id
    @Column(name = "client_Id")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "country_code")
    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "mobile")
    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (clientId != that.clientId) return false;
        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<ClientJobDetailsEntity> getClientJobDetailsByClientId() {
        return clientJobDetailsByClientId;
    }

    public void setClientJobDetailsByClientId(Collection<ClientJobDetailsEntity> clientJobDetailsByClientId) {
        this.clientJobDetailsByClientId = clientJobDetailsByClientId;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<ClientWorkTimingEntity> getClientWorkTimingsByClientId() {
        return clientWorkTimingsByClientId;
    }

    public void setClientWorkTimingsByClientId(Collection<ClientWorkTimingEntity> clientWorkTimingsByClientId) {
        this.clientWorkTimingsByClientId = clientWorkTimingsByClientId;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<TimeSheetEntity> getTimeSheetsByClientId() {
        return timeSheetsByClientId;
    }

    public void setTimeSheetsByClientId(Collection<TimeSheetEntity> timeSheetsByClientId) {
        this.timeSheetsByClientId = timeSheetsByClientId;
    }
}
