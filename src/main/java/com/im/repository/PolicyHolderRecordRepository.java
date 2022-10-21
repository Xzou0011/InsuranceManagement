package com.im.repository;

import com.im.model.Customer;
import com.im.model.PolicyHolderRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import static org.springframework.data.repository.query.parser.Part.Type.LIKE;

@Repository //with Spring Data JPA, you don't have to write any Database access objects (DAO) code. At runtime, Spring Data JPA automatically generates the implementation code.
public interface PolicyHolderRecordRepository extends JpaRepository<PolicyHolderRecord, Long> {

    /*
    As with Spring Data JPA, you don't have to write any DAO code.
    Just declare an interface that extends the CrudRepository interface
    which defines CRUD methods like save(), findAll(), findById(),deleteById(), etc.
    At runtime, Spring Data JPA automatically generates the implementation code.

    NOTE: that we must specify the type of the model class and type of the primary key field when extending the JPA/CrudRepository interface
    EX: CrudRepository<Pokemon, Long>
    */

    //the search()method is just an abstract method annotated with the @Query annotation. The search query is JPA query.
    @Query(value = "SELECT p FROM PolicyHolderRecord p WHERE " +
            "lower(p.policyId) LIKE lower(CONCAT('%', :policyId, '%')) AND " +
            "lower(p.customerId) LIKE lower(CONCAT('%', :customerId, '%')) AND " +
            "lower(p.appliedDate) LIKE lower(CONCAT('%', :appliedDate, '%'))")

    List<PolicyHolderRecord> search(@Param("policyId") String policyId, @Param("customerId") String customerId, @Param("appliedDate") String appliedDate);
}