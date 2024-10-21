package br.com.iconcourses.regesc.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="professores")
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String prontuario;
	@OneToMany(mappedBy="professor", fetch=FetchType.EAGER)
	@JsonManagedReference(value="professor_disciplina")
	private Set<Disciplina> disciplinas;
	
	public Professor() {
		super();
	}

	public Professor(Long id, String nome, String prontuario, Set<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.prontuario = prontuario;
		this.disciplinas = disciplinas;
	}


	/**
	 * @return the id_professor
	 */
	public Long getId() {
		return this.id;
	}


	/**
	 * @param id_professor the id_professor to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the prontuario
	 */
	public String getProntuario() {
		return prontuario;
	}

	/**
	 * @param prontuario the prontuario to set
	 */
	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	/**
	 * @return the disciplinas
	 */
	public Set<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	/**
	 * @param disciplinas the disciplinas to set
	 */
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
