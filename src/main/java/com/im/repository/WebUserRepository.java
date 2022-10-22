package com.im.repository;

import com.im.model.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {

    @Query(value = "SELECT b FROM WebUser b WHERE b.userName = :userName")
    public WebUser login(@Param("userName") String userName);
}
