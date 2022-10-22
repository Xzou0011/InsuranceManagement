package com.im.repository;

import com.im.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Query(value = "SELECT p FROM Policy p WHERE " +
            "lower(p.policyId) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.policeType) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(p.policyDesr) LIKE lower(CONCAT('%', :keyword, '%'))")

    public List<Policy> search(@Param("keyword") String keyword);
}