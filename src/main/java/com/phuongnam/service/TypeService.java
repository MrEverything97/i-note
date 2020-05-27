package com.phuongnam.service;

import com.phuongnam.model.Type;
import org.springframework.stereotype.Service;



@Service
public interface TypeService {
    Iterable<Type> findAll();

    Type findById(Long id);

    void save(Type type);

    void remove(Long id);

}
