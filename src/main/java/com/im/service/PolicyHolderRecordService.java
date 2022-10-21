package com.im.service;

import com.im.model.Customer;
import com.im.model.PolicyHolderRecord;
import com.im.repository.PolicyHolderRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
//@Transactional annotation so all of its methods will be intercepted by Spring Data JPA for transaction management
@Transactional
public class PolicyHolderRecordService {

    //instance of CustomerRepository will be injected into this class:
    @Autowired
    PolicyHolderRecordRepository repo;

    public void save(PolicyHolderRecord policyHolderRecord) {
        repo.save(policyHolderRecord);
    }

    public List<PolicyHolderRecord> listAll() {
        return (List<PolicyHolderRecord>) repo.findAll();
    }

    public PolicyHolderRecord get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<PolicyHolderRecord> search(String policyId, String customerId, String appliedDate) {
        return repo.search(policyId, customerId, appliedDate);
    }

}