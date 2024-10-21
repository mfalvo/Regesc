package br.com.iconcourses.regesc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.iconcourses.regesc.model.DisciplinaAluno;

@Repository
public interface DisciplinaAlunoRepository extends CrudRepository<DisciplinaAluno, Long> {

}
	