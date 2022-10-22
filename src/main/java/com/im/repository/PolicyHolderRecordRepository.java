package com.im.repository;

import com.im.model.PolicyHolderRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository //with Spring Data JPA, you don't have to write any Database access objects (DAO) code. At runtime, Spring Data JPA automatically generates the implementation code.
public interface PolicyHolderRecordRepository extends JpaRepository<PolicyHolderRecord, Long> {

    //the search()method is just an abstract method annotated with the @Query annotation. The search query is JPA query.
    @Query(value = "SELECT p FROM PolicyHolderRecord p WHERE " +
            "lower(p.policyId) LIKE lower(CONCAT('%', :policyId, '%')) AND " +
            "lower(p.customerId) LIKE lower(CONCAT('%', :customerId, '%')) AND " +
            "lower(p.appliedDate) LIKE lower(CONCAT('%', :appliedDate, '%'))")


    //@Query("SELECT p FROM PolicyHolderRecord p WHERE p.policyId = ?1 and p.customerId = ?2 and p.appliedDate = ?3")
    List<PolicyHolderRecord> search(@Param("policyId") String policyId, @Param("customerId") String customerId, @Param("appliedDate") String appliedDate);
    //PolicyHolderRecord search(String policyId, String customerId, String appliedDate);
}