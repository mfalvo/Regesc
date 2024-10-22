package br.com.iconcourses.regesc.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	@JoinColumn(name = "professor_id", nullable = false)
	@JsonBackReference
	private Professor professor;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name = "disciplina_aluno",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
        )
    @JsonIgnore
    private Set<Aluno> aluno;
    
	public Disciplina() {
		super();
	}

	public Disciplina(Long id, String nome, Integer semestre, Professor professor, Set<Aluno> aluno) {
		super();
		this.id = id;
		this.nome = nome;
		this.semestre = semestre;
		this.professor = professor;
		this.aluno = aluno;
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
		return nome;
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

	/**
	 * @return the aluno
	 */
	public Set<Aluno> getAluno() {
		return this.aluno;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(Set<Aluno> aluno) {
		this.aluno = aluno;
	}
	
	
	
}
