package com.phuongnam.service.impl;

import com.phuongnam.model.Note;
import com.phuongnam.model.Type;
import com.phuongnam.repository.NoteRepository;
import com.phuongnam.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByTitleContainingIgnoreCase(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContainingIgnoreCase(title,pageable);
    }

    @Override
    public Iterable<Note> findAllByType(Type type) {
        return noteRepository.findAllByType(type);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(Long id) {
        noteRepository.deleteById(id);
    }
}
