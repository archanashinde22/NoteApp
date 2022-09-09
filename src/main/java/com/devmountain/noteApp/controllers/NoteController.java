package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

// get all notes by user id
    @GetMapping("/user/{userId}")
    public List<NoteDto> getNotesByUser(@PathVariable Long userId){
        return noteService.getAllNoteByUserId(userId);
    }
// get a note by note id
    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNoteById(@PathVariable Long noteId){
        return  noteService.getNoteById(noteId);
    }
//    Add a new Note by note and userid
    @PostMapping("/user/{userId}")
    public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId){
        noteService.addNote(noteDto,userId);
    }

// Delete a Note by note id

    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId){
        noteService.deleteNoteById(noteId);
    }

    // update existing note by note
    @PutMapping
    public void updateNote(@RequestBody NoteDto noteDto){
        noteService.updateNoteById(noteDto);
    }

}
