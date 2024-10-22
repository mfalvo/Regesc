package br.com.iconcourses.regesc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iconcourses.regesc.model.Aluno;
import br.com.iconcourses.regesc.model.Disciplina;
import br.com.iconcourses.regesc.repository.AlunoRepository;
import br.com.iconcourses.regesc.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
    private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	
	@PostMapping("/{disciplinaId}/alunos/{alunoId}")
    public ResponseEntity<Disciplina> addAlunoToDisciplina(@PathVariable Long disciplinaId, @PathVariable Long alunoId) {
        Optional<Disciplina> disciplinaOpt = disciplinaRepository.findById(disciplinaId);
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);

        if (!disciplinaOpt.isPresent() || !alunoOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Disciplina disciplina = disciplinaOpt.get();
        Aluno aluno = alunoOpt.get();
        
        disciplina.getAluno().add(aluno);
        disciplinaRepository.save(disciplina);

        return ResponseEntity.ok(disciplina);
    }

    @GetMapping
    public Iterable<Disciplina> getAll() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Disciplina> getById(@PathVariable Long id) {
        return disciplinaRepository.findById(id);
    }
    
    @PostMapping  
    public ResponseEntity<?> insert(@RequestBody Disciplina disciplina) {
        Optional<Disciplina> existingDisciplina = disciplinaRepository.findByNomeAndProfessor_Id(disciplina.getNome(), disciplina.getProfessor().getId());
        if (existingDisciplina.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A disciplina com o mesmo professor já existe.");
        }
        Disciplina savedDisciplina = disciplinaRepository.save(disciplina);
        return ResponseEntity.ok(savedDisciplina);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Disciplina disciplina) {
 
        Optional<Disciplina> existingDisciplina = disciplinaRepository.findByNomeAndProfessor_Id(disciplina.getNome(), id);
        if (existingDisciplina.isPresent()) {
        	return ResponseEntity.status(HttpStatus.CONFLICT).body("A disciplina com o mesmo professor já existe.");
        }
        disciplina.setId(id);
        Disciplina savedDisciplina = disciplinaRepository.save(disciplina);
        return ResponseEntity.ok(savedDisciplina);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
    }
	
	

}