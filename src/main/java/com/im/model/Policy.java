package com.im.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Policy {
    @Id
    //@GeneratedValue annotations to indicate that this field is primary key and its value is auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String policeType;
    private String policyDesr;

    public Policy(){

    }

    public Policy(Long policyId, String policeType, String policyDesr) {
        this.policyId = policyId;
        this.policeType = policeType;
        this.policyDesr = policyDesr;
    }

    public Long getPolicyId() {
        return policyId;
    }
    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
    public String getPoliceType() {
        return policeType;
    }
    public void setPoliceType(String policeType) {
        this.policeType = policeType;
    }
    public String getPolicyDesr() {
        return policyDesr;
    }
    public void setPolicyDesr(String policyDesr) {
        this.policyDesr = policyDesr;
    }

}
