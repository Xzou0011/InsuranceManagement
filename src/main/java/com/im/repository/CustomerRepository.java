package com.im.repository;

import com.im.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //with Spring Data JPA, you don't have to write any Database access objects (DAO) code. At runtime, Spring Data JPA automatically generates the implementation code.
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /*
    As with Spring Data JPA, you don't have to write any DAO code.
    Just declare an interface that extends the CrudRepository interface
    which defines CRUD methods like save(), findAll(), findById(),deleteById(), etc.
    At runtime, Spring Data JPA automatically generates the implementation code.

    NOTE: that we must specify the type of the model class and type of the primary key field when extending the JPA/CrudRepository interface
    EX: CrudRepository<Pokemon, Long>
    */

    //the search()method is just an abstract method annotated with the @Query annotation. The search query is JPA query.
    @Query(value = "SELECT c FROM Customer c WHERE " +
            "lower(c.customerId) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.name) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.address) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.contactNumber) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.emailAddress) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.sex) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.dateOfBirth) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.employmentStatus) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(c.riskRate) LIKE lower(CONCAT('%', :keyword, '%'))")
    public List<Customer> search(@Param("keyword") String keyword);

    @Query("SELECT c FROM Customer c WHERE c.customerId = ?1 AND c.name = ?2")
    List<Customer> findByIdAndName(Long customerId, String name);
}