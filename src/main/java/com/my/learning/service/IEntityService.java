package com.my.learning.service;

import com.my.learning.entity.User;

import java.util.List;
import java.util.Optional;

public interface IEntityService<T> {

    T add(T entity);

    List get();

    long count();

    Optional<T> get(Long id);

    void delete(Long id);

    Optional<T> findByProperty(String propertyName, String value);
}
