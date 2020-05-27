package com.phuongnam.repository;

import com.phuongnam.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends PagingAndSortingRepository<Type, Long> {
}
