package com.example.springbootmysqlqueryexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootmysqlqueryexample.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Modifying
    @Query(value = "insert into Member (name, username) values (:name, :username)",
            nativeQuery = true)
    int saveWithDifferentIsolationLevel(@Param("name") String name,
                                        @Param("username") String username);
}
