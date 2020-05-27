package com.phuongnam.service;

import com.phuongnam.model.Note;
import com.phuongnam.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {
    Page<Note> findAll(Pageable pageable);

    Page<Note> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

    Iterable<Note> findAllByType(Type type);

    Note findById(Long id);

    void save(Note note);

    void remove(Long id);

}
