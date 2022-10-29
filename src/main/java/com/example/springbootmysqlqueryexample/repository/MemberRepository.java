package com.example.springbootmysqlqueryexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootmysqlqueryexample.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
