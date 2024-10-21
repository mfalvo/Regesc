package br.com.iconcourses.regesc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.iconcourses.regesc.model.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
	