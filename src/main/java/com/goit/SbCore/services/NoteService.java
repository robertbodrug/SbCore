package com.goit.SbCore.services;

import com.goit.SbCore.model.Note;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
@Slf4j
@Service
public class NoteService {
    Map<Long, Note> dataBase = new HashMap<>();
    Random rand = new Random();

    @PostConstruct
    private void init() throws FileNotFoundException {
        dataBase.put(1L, new Note(1L, "a", "aaa"));
        dataBase.put(2L, new Note(2L, "b", "bbb"));
        dataBase.put(3L, new Note(3L, "c", "ccc"));
        log.info(listAll().toString());
        add(new Note(0L, "f", "fff"));
        add(new Note(0L, "d", "ddd"));
        deleteById(2L);
        update(new Note(1L, "g", "ggg"));
        getById(1);
        log.info(listAll().toString());
    }

    public List<Note> listAll() {
        return dataBase.values().stream().toList();
    }

    public Note add(Note note) {
        Long newId = rand.nextLong(1000);
        note.setId(newId);
        dataBase.put(newId, note);
        return note;
    }

    public void deleteById(long id) throws FileNotFoundException {
        if (dataBase.containsKey(id)) {
            dataBase.remove(id);
        } else {
            throw new FileNotFoundException("");
        }
    }

    public void update(Note note) throws FileNotFoundException {
        Long id = note.getId();
        if (dataBase.containsKey(id)) {
            dataBase.put(id,note);
        } else {
            throw new FileNotFoundException();
        }
    }
    public  Note getById(long id) throws FileNotFoundException {
        if (dataBase.containsKey(id)) {
            return dataBase.get(id);
        } else {
            throw new FileNotFoundException();
        }
    }

}
