package br.com.iconcourses.regesc.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="disciplinas")
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	private Integer semestre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="idprofessor", nullable = true)
	@JsonBackReference(value="professor_disciplina")
	private Professor professor;
	
	 
    @OneToMany(mappedBy = "disciplina", fetch = FetchType.EAGER)
    @JsonManagedReference(value="disciplina_disciplinaAluno") // Anotação para resolver serialização bidirecional
    private Set<DisciplinaAluno> disciplinaAlunos;

	public Disciplina() {
		super();
	}


	public Disciplina(Long id, String nome, Integer semestre, Professor professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.semestre = semestre;
		this.professor = professor;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the semestre
	 */
	public Integer getSemestre() {
		return semestre;
	}


	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}


	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}


	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
}
