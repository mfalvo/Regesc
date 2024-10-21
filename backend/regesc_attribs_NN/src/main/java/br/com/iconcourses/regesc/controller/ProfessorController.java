package br.com.iconcourses.regesc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iconcourses.regesc.model.Professor;
import br.com.iconcourses.regesc.repository.ProfessorRepository;



@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public Iterable<Professor> getAll() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id);
    }
    
    @PostMapping
    public Professor insertProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        professor.setId(id);
        return professorRepository.save(professor);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }
	
	

}
