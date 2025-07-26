package com.allysonprojects.notes.controllers;

import com.allysonprojects.notes.models.Note;
import com.allysonprojects.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
String username = userDetails.getUsername();
        System.out.println("User Details: " + username);
        return noteService.createNoteForUser(username, content); //inline
    }

    @GetMapping
    public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("User Details: " + username);
        List<Note> allNotes = noteService.getNotesForUser(username); //longform
        return allNotes;
    }

    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable Long noteId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        System.out.println("User Details: " + username);
        return noteService.updateNoteForUser(noteId, content,username);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        System.out.println("User Details: " + username);
        noteService.deleteNoteForUser(noteId, username);
    }
}
