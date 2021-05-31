package com.my.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.learning.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Long> {

}
