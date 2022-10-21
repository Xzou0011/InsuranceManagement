package com.im.service;

import com.im.model.Customer;
import com.im.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
//@Transactional annotation so all of its methods will be intercepted by Spring Data JPA for transaction management
@Transactional
public class CustomerService {

    //instance of CustomerRepository will be injected into this class:
    @Autowired
    CustomerRepository repo;

    public void save(Customer customer) {
        repo.save(customer);
    }

    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }

    public Customer get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

//    public List<Customer> search(String keyword) {
//        return repo.search(keyword);
//    }

    public List<Customer> findByIdAndName (Long customerId, String name){
        return repo.findByIdAndName(customerId, name);
    }

}