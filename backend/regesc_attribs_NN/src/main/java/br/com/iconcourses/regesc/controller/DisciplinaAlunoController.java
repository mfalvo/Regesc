package br.com.iconcourses.regesc.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import br.com.iconcourses.regesc.model.DisciplinaAluno;
import br.com.iconcourses.regesc.model.DisciplinaAlunoDTO;
import br.com.iconcourses.regesc.repository.AlunoRepository;
import br.com.iconcourses.regesc.repository.DisciplinaAlunoRepository;

@RestController
@RequestMapping("/disciplina_aluno")
public class DisciplinaAlunoController {
	
	@Autowired
    private DisciplinaAlunoRepository disciplina_alunoRepository;

	@GetMapping
    public List<DisciplinaAlunoDTO> getAll() {
        List<DisciplinaAluno> disciplinaAlunos = (List<DisciplinaAluno>) disciplina_alunoRepository.findAll();
        return disciplinaAlunos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
	
	@GetMapping("/{id}")
    public DisciplinaAlunoDTO getById(@PathVariable Long id) {
        Optional<DisciplinaAluno> disciplinaAluno = disciplina_alunoRepository.findById(id);
        return disciplinaAluno.map(this::convertToDTO).orElse(null);
    }

    
    @PostMapping
    public DisciplinaAlunoDTO insert(@RequestBody DisciplinaAluno disciplinaAluno) {
        DisciplinaAluno savedDisciplinaAluno = disciplina_alunoRepository.save(disciplinaAluno);
        return convertToDTO(savedDisciplinaAluno);
    }

        		    

    private DisciplinaAlunoDTO convertToDTO(DisciplinaAluno disciplinaAluno) {
            DisciplinaAlunoDTO dto = new DisciplinaAlunoDTO();
    	        dto.setId(disciplinaAluno.getId());
    	        dto.setDisciplinaId(disciplinaAluno.getDisciplina().getId());
    	        dto.setDisciplinaNome(disciplinaAluno.getDisciplina().getNome());
    	        dto.setAlunoId(disciplinaAluno.getAluno().getId());
    	        dto.setAlunoNome(disciplinaAluno.getAluno().getNome());
    	        dto.setAlunoIdade(disciplinaAluno.getAluno().getIdade());
    	        dto.setData(disciplinaAluno.getData());
    	        return dto;
    	    }
    
}

    
    
    
    
																																																
