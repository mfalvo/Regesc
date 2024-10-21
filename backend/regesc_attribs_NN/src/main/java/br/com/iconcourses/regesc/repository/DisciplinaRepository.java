package br.com.iconcourses.regesc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.iconcourses.regesc.model.Disciplina;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long>  {
	
	 Optional<Disciplina> findByNomeAndProfessor_Id(String nome, Long professorId);

}
