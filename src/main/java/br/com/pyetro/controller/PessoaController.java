package br.com.pyetro.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.pyetro.domain.Pessoa;
import br.com.pyetro.service.IPessoaService;

@Named
@ViewScoped
public class PessoaController implements Serializable{

	private static final long serialVersionUID = -7407730856594618438L;
	
	private Pessoa pessoa;
	
	private Collection<Pessoa> pessoas;
	
	@Inject
	private IPessoaService pessoaService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.pessoa = new Pessoa();
            this.pessoas = pessoaService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar as pessoas"));
        }
    }

	@Transactional
	public void cancel() {
        try {
            this.isUpdate = false;
            this.pessoa = new Pessoa();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }
    }

	@Transactional
	public void edit(Pessoa pessoa) {
        try {
            this.isUpdate = true;
            this.pessoa = pessoa;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar a pessoa"));
        }
    }

	@Transactional
	public void delete(Pessoa pessoa) {
        try {
            pessoaService.excluir(pessoa);
            pessoas.remove(pessoa);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir a pessoa"));
        }
    }

	@Transactional
	public void add() {
        try {
            pessoaService.cadastrar(pessoa);
            this.pessoas = pessoaService.buscarTodos();
            this.pessoa = new Pessoa();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar a pessoa"));
        }
    }

	@Transactional
	public void update() {
        try {
            pessoaService.alterar(this.pessoa);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Pessoa atualizada com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar a pessoa"));
        }
    }

	
	public Collection<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Collection<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }	

}
