package com.im.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "policys")
public class Policy {
    @Id
    //@GeneratedValue annotations to indicate that this field is primary key and its value is auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String policeType;
    private String policyDesr;

    @OneToMany(mappedBy = "policy")
    private Set<PolicyHolderRecord> phrs;


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
