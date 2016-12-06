package br.cefetrj.webdep.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entidade de banco de dados correspondente a tabela Versão.
 * 
 * @author diogo
 * @since 0.1
 */
@Entity
public class Versao  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false)
	private LocalDateTime timestampLiberacao;

	@ManyToOne
	@JoinColumn(name="versoes")
	private Sistema sistema;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getTimestampLiberacao() {
		return timestampLiberacao;
	}

	public void setTimestampLiberacao(LocalDateTime timestampLiberacao) {
		this.timestampLiberacao = timestampLiberacao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	
	
}