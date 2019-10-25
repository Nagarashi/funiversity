package com.switchfully.funiversity.domain.professors;

import java.util.Collection;

public interface ProfessorDao {

    Professor save(Professor professor);

    Professor getById(String id) throws IllegalArgumentException;

    Collection<Professor> getAll();

    void remove(String id);
}
