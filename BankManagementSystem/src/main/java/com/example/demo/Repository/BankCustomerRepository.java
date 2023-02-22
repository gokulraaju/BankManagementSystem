package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.BankCustomerEntity;

@Repository
public interface BankCustomerRepository extends JpaRepository<BankCustomerEntity, Long> {


}
