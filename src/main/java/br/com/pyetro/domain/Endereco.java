package br.com.pyetro.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Endereco implements Persistente {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="endereco_seq")
    @SequenceGenerator(name="endereco_seq", sequenceName="sq_endereco", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NUMERO")
	private int numero;
	
	@Column(name = "CEP")
	private String cep;
	
	@ManyToOne
    @JoinColumn(name = "PESSOA_ID")
	private Pessoa pessoa;	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public Long getId() {		
		return id;	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

}
