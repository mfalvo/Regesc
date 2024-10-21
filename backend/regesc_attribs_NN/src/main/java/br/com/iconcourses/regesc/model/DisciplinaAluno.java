package br.com.iconcourses.regesc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="disciplinas_alunos")
public class DisciplinaAluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="disciplina_fk", nullable=false)
    @JsonBackReference // Anotação para resolver serialização bidirecional
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="aluno_fk", nullable=true)
    @JsonBackReference // Anotação para resolver serialização bidirecional
	private Aluno aluno;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date data;

	public DisciplinaAluno(Disciplina disciplina, Aluno aluno, Date data) {
		super();
		this.disciplina = disciplina;
		this.aluno = aluno;
		this.data = data;
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
	 * @return the disciplina
	 */
	public Disciplina getDisciplina() {
		return disciplina;
	}

	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	/**
	 * @return the aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	
}
