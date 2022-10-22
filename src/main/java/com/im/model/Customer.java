package com.im.model;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;
    private String name;
    private String address;
    private Long contactNumber;
    private String emailAddress;
    private String sex;
    private Date dateOfBirth;
    private boolean employmentStatus;
    private Double riskRate;
    private int agent_customer_id;

    @OneToMany(mappedBy = "customer")
    private Set<PolicyHolderRecord> phrs;

    public Customer() {
    }

    public Customer(Long customerId, String name, String address, Long contactNumber, String emailAddress, String sex,
                    Date dateOfBirth, boolean employmentStatus, Double riskRate, int agent_customer_id) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.employmentStatus = employmentStatus;
        this.riskRate = riskRate;
        this.agent_customer_id = agent_customer_id;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public Double getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(Double riskRate) {
        this.riskRate = riskRate;
    }

    public int getAgent_customer_id() {
        return agent_customer_id;
    }

    public void setAgent_customer_id(int agent_customer_id) {
        this.agent_customer_id = agent_customer_id;
    }

    public Set<PolicyHolderRecord> getPhrs() {
        return phrs;
    }

    public void setPhrs(Set<PolicyHolderRecord> phrs) {
        this.phrs = phrs;
    }
}
