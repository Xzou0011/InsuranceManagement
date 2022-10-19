package com.im.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PolicyHolderRecord {
    @Id
    //@GeneratedValue annotations to indicate that this field is primary key and its value is auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phrId;
    private Date appliedDate;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private boolean premium;
    private String otherDetails;
    private Long customerId;
    private Long policyId;

    public PolicyHolderRecord(){

    }

    public PolicyHolderRecord(Long phrId, Date appliedDate, Date startDate, Date endDate, boolean status,
                              boolean premium, String otherDetails, Long customerId, Long policyId){
        this.phrId = phrId;
        this.appliedDate = appliedDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.premium = premium;
        this.otherDetails = otherDetails;
        this.customerId = customerId;
        this.policyId = policyId;
    }

    public Long getPhrId() {
        return phrId;
    }
    public void setPhrId(Long phrId) {
        this.phrId = phrId;
    }
    public Date getAppliedDate() {
        return appliedDate;
    }
    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean isPremium() {
        return premium;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    public String getOtherDetails() {
        return otherDetails;
    }
    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
}
