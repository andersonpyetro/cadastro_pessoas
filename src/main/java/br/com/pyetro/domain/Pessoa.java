package br.com.pyetro.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa implements Persistente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_seq")
    @SequenceGenerator(name="pessoa_seq", sequenceName="sq_pessoa", initialValue = 1, allocationSize = 1)
    private Long id;
    
    @Column(name = "NOME", nullable = false, length = 150)
    private String nome;
    
    @Column(name = "CPF", nullable = false, length = 11, unique = true)
    private long cpf;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "IDADE")
    private Date idade;
    
    @Column(name = "SEXO")
    private String sexo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;


	public Long getId() {
		return id;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
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

	public Date getIdade() {
		return idade;
	}

	public void setIdade(Date idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}        	

}
