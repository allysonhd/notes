package com.allysonprojects.notes.services.impl;

import com.allysonprojects.notes.models.Note;
import com.allysonprojects.notes.repositories.NoteRepository;
import com.allysonprojects.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNoteForUser (String username, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        Note savedNote = noteRepository.save(note); //redundant, used to show what's happening
        return savedNote;
    }

    @Override
    public Note updateNoteForUser (Long noteId, String content, String username) {
        Note note = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note not found"));
        note.setContent(content);
        return noteRepository.save(note); //inline variable, eliminates redundancy
    }

    @Override
    public void deleteNoteForUser(Long noteId, String username){
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesForUser(String username){
        return noteRepository.findByOwnerUsername(username); //inline variable, eliminates redundancy
    }
}
