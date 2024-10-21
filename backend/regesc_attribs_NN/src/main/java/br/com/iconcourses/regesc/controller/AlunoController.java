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

import br.com.iconcourses.regesc.model.Aluno;
import br.com.iconcourses.regesc.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public Iterable<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> getById(@PathVariable Long id) {
        return alunoRepository.findById(id);
    }
    
    @PostMapping
    public Aluno insert(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }
	
	

}
