package com.im.service;

import com.im.model.PolicyHolderRecord;
import com.im.repository.PolicyHolderRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PolicyHolderRecordService {

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