package com.im.repository;

import com.im.model.PolicyHolderRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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
            "lower(p.phrId) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.appliedDate) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.startDate) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.endDate) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.status) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.premium) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.otherDetails) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.customerId) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.policyId) LIKE lower(CONCAT('%', :keyword, '%'))")
    public List<PolicyHolderRecord> search(@Param("keyword") String keyword);
}