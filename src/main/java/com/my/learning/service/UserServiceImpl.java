package com.my.learning.service;

import com.my.learning.entity.Customer;
import com.my.learning.entity.User;
import com.my.learning.repository.ICustomerRepo;
import com.my.learning.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IEntityService<User> {

    @Autowired
    IUserRepo userRepo;

    @Override
    public User add(User user) {
        return userRepo.save(user);
    }

    @Override
    public List get() {
        return userRepo.findAll();
    }

    @Override
    public long count() {
        return userRepo.count();
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            userRepo.delete(get(id).get());
        }
    }

    public Optional<User> findByProperty(String propertyName, String value){
        if(propertyName.equalsIgnoreCase("userName"))
        {
            return userRepo.findByUserName(value);
        }
        else{
            return null;
        }
    }
}
