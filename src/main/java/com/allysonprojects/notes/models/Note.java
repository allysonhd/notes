package com.allysonprojects.notes.models;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data //generating getters, setters, constructors
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob //large object in db - allows long string storage
    private String content;

    private String ownerUsername;
}
