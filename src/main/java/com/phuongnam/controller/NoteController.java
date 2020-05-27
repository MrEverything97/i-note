package com.phuongnam.controller;

import com.phuongnam.model.Note;
import com.phuongnam.model.Type;
import com.phuongnam.service.NoteService;
import com.phuongnam.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private TypeService typeService;
    @ModelAttribute("types")
    public Iterable<Type> phones(){
        return typeService.findAll();
    }
    @GetMapping("/notes")
    public ModelAndView listNotes(@PageableDefault(size = 3) Pageable pageable, @RequestParam("s") Optional<String> s ){
        Page<Note> notes;
        if(s.isPresent()){
            notes = noteService.findAllByTitleContainingIgnoreCase(s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @GetMapping("/create-note")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("note/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView saveNote(@ModelAttribute("note") Note note) {
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("note/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("message", "Done!");
        return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Note note = noteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/edit-note")
    public ModelAndView updateNote(@ModelAttribute("note") Note note) {
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("message", "Edit was successful !");
        return modelAndView;
    }

    @GetMapping("/delete-note/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Note note = noteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("note/delete");
        modelAndView.addObject("note", note);
        return modelAndView;

    }

    @PostMapping("/delete-note")
    public String deleteNote(@ModelAttribute("note") Note note) {
        noteService.remove(note.getId());
        return "redirect:notes";
    }
    @GetMapping("/view-note/{id}")
    public ModelAndView showNoteDetail(@PathVariable Long id) {
        Note note = noteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("note/view");
        modelAndView.addObject("note", note);
        return modelAndView;
    }
}
