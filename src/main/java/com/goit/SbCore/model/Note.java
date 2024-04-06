package com.goit.SbCore.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Note {
    private Long id;
    private String title;
    private String content;

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
