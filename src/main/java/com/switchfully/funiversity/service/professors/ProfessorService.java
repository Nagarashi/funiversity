package com.switchfully.funiversity.service.professors;

import com.switchfully.funiversity.api.professors.ProfessorController;
import com.switchfully.funiversity.api.professors.dtos.CreateProfessorDto;
import com.switchfully.funiversity.api.professors.dtos.UpdateProfessorDto;
import com.switchfully.funiversity.domain.professors.Professor;
import com.switchfully.funiversity.domain.professors.ProfessorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Component
public class ProfessorService {
    private ProfessorDao professorDao;

    @Autowired
    public ProfessorService(ProfessorDao professorDao) {
        this.professorDao = professorDao;
    }


    public Collection<Professor> getAllProfessors() {
        return professorDao.getAll();
    }

    public Professor get(String id) {
        return professorDao.getById(id);
    }

    public Professor saveProfessor (Professor professor) {
        return professorDao.save(professor);
    }

    public void removeProfessor (String id) {
        professorDao.remove(id);
    }

    public Professor createProfessor(CreateProfessorDto createProfessorDto) {
        return new Professor(createProfessorDto.getFirstName(), createProfessorDto.getLastName());
    }

    public Professor updateProfessor(String id, UpdateProfessorDto updateProfessorDto) {
        return new Professor(get(id).getId(), updateProfessorDto.getFirstName(), updateProfessorDto.getLastName());
    }
}
