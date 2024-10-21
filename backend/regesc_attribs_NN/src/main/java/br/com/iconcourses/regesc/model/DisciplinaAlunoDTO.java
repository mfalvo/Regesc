package br.com.iconcourses.regesc.model;

import java.util.Date;

public class DisciplinaAlunoDTO {
    private Long id;
    private Long disciplinaId;
    private String disciplinaNome;
    private Long alunoId;
    private String alunoNome;
    private Integer alunoIdade;
    private Date data;
    
    // Construtores, getters e setters
    
    
	public DisciplinaAlunoDTO() {
		super();
	}

	public DisciplinaAlunoDTO(Long id, Long disciplinaId, String disciplinaNome, Long alunoId, String alunoNome,
			Integer alunoIdade, Date data) {
		super();
		this.id = id;
		this.disciplinaId = disciplinaId;
		this.disciplinaNome = disciplinaNome;
		this.alunoId = alunoId;
		this.alunoNome = alunoNome;
		this.alunoIdade = alunoIdade;
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
	 * @return the disciplinaId
	 */
	public Long getDisciplinaId() {
		return disciplinaId;
	}

	/**
	 * @param disciplinaId the disciplinaId to set
	 */
	public void setDisciplinaId(Long disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	/**
	 * @return the disciplinaNome
	 */
	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	/**
	 * @param disciplinaNome the disciplinaNome to set
	 */
	public void setDisciplinaNome(String disciplinaNome) {
		this.disciplinaNome = disciplinaNome;
	}

	/**
	 * @return the alunoId
	 */
	public Long getAlunoId() {
		return alunoId;
	}

	/**
	 * @param alunoId the alunoId to set
	 */
	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	/**
	 * @return the alunoNome
	 */
	public String getAlunoNome() {
		return alunoNome;
	}

	/**
	 * @param alunoNome the alunoNome to set
	 */
	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}

	/**
	 * @return the alunoIdade
	 */
	public Integer getAlunoIdade() {
		return alunoIdade;
	}

	/**
	 * @param alunoIdade the alunoIdade to set
	 */
	public void setAlunoIdade(Integer alunoIdade) {
		this.alunoIdade = alunoIdade;
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
