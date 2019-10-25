package com.switchfully.funiversity.domain.professors;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProfessorRepository implements ProfessorDao {

    private final ConcurrentHashMap<String, Professor> professorsById;

    public ProfessorRepository() {
        professorsById = new ConcurrentHashMap<>();
    }

    @Override
    public Professor save(Professor professor) {
        professorsById.put(professor.getId(), professor);
        return professor;
    }

    @Override
    public Professor getById(String id) throws IllegalArgumentException {
        var foundProfessor = professorsById.get(id);
        if (foundProfessor == null) {
            throw new IllegalArgumentException("No Professor could be found for id " + id);
        }
        return foundProfessor;
    }

    @Override
    public Collection<Professor> getAll() {
        return professorsById.values();
    }

    @Override
    public void remove(String id) {
        professorsById.remove(id);
    }
}
