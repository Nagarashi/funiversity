package com.switchfully.funiversity.api.professors;

import com.switchfully.funiversity.api.FuniversityMapper;
import com.switchfully.funiversity.api.professors.dtos.CreateProfessorDto;
import com.switchfully.funiversity.api.professors.dtos.ProfessorDto;
import com.switchfully.funiversity.api.professors.dtos.UpdateProfessorDto;
import com.switchfully.funiversity.service.professors.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {
    private ProfessorService professorService;
    private FuniversityMapper funiversityMapper;

    @Autowired
    public ProfessorController(ProfessorService professorService, FuniversityMapper funiversityMapper) {
        this.professorService = professorService;
        this.funiversityMapper = funiversityMapper;
    }


    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDto> getProfessors() {
        return professorService.getAllProfessors().stream()
                .map(professor -> funiversityMapper.mapToProfessorDto(professor))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getProfessor(@PathVariable("id") String id) {
        return funiversityMapper.mapToProfessorDto(professorService.get(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(@RequestBody CreateProfessorDto createProfessorDto) {
        return funiversityMapper.mapToProfessorDto(
                professorService.saveProfessor(
                        professorService.createProfessor(createProfessorDto)));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto modifyProfessor(@PathVariable("id") String id, @RequestBody UpdateProfessorDto updateProfessorDto) {
        return funiversityMapper.mapToProfessorDto(
                professorService.saveProfessor(
                        professorService.updateProfessor(id, updateProfessorDto)));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CONTINUE)
    public void deleteProfessor(@PathVariable("id") String id) {
        professorService.removeProfessor(id);
    }

}
