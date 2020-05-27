package com.phuongnam.repository;

import com.phuongnam.model.Note;
import com.phuongnam.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
    Page<Note> findAllByTitleContainingIgnoreCase(String name, Pageable pageable);

    Iterable<Note> findAllByType(Type type);
}
