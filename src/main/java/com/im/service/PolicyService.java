package com.im.service;

import com.im.model.Policy;
import com.im.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PolicyService {

    //instance of CustomerRepository will be injected into this class:
    @Autowired
    PolicyRepository repo;

    public void save(Policy policy) {
        repo.save(policy);
    }

    public List<Policy> listAll() {
        return (List<Policy>) repo.findAll();
    }

    public Policy get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Policy> search(String keyword) {
        return repo.search(keyword);
    }

}