package com.my.learning.service;

import java.util.List;
import java.util.Optional;

import com.my.learning.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.learning.entity.Customer;
import com.my.learning.repository.ICustomerRepo;

@Service
public class CustomerServiceImpl implements IEntityService<Customer> {

    @Autowired
    ICustomerRepo customerRepo;

    @Override
    public Customer add(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List get() {
        return customerRepo.findAll();
    }

    @Override
    public long count() {
        return customerRepo.count();
    }

    @Override
    public Optional<Customer> get(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            customerRepo.delete(get(id).get());
        }
    }

    public Optional<Customer> findByProperty(String propertyName, String value){
        return null;
    }
}
