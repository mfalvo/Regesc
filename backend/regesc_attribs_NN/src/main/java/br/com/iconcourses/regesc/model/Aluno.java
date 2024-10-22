package br.com.iconcourses.regesc.model;

import java.util.List;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="alunos")
public class Aluno {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable=false)
		private String nome;
		
		private Integer idade;
		
		@ManyToMany(mappedBy = "aluno", fetch=FetchType.EAGER)
		@JsonIgnore
		private Set<Disciplina> disciplina;
		
		 


		public Aluno() {
			super();
		}
		
		public Aluno(Long id, String nome, Integer idade, Set<Disciplina> disciplina) {
			super();
			this.id = id;
			this.nome = nome;
			this.idade = idade;
			this.disciplina = disciplina;
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
		 * @return the idade
		 */
		public Integer getIdade() {
			return idade;
		}

		/**
		 * @param idade the idade to set
		 */
		public void setIdade(Integer idade) {
			this.idade = idade;
		}

		/**
		 * @return the disciplinaAlunos
		 */
		public Set<Disciplina> getDisciplina() {
			return disciplina;
		}

		/**
		 * @param disciplinaAlunos the disciplinaAlunos to set
		 */
		public void setDisciplina(Set<Disciplina> disciplina) {
			this.disciplina = disciplina;
		}
		
}



