package com.phuongnam.service.impl;

import com.phuongnam.model.Type;
import com.phuongnam.repository.TypeRepository;
import com.phuongnam.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type findById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void remove(Long id) {
        typeRepository.deleteById(id);
    }
}
