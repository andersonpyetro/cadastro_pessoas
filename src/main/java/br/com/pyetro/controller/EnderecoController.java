package br.com.pyetro.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.pyetro.domain.Endereco;
import br.com.pyetro.domain.Pessoa;
import br.com.pyetro.service.EnderecoService;

@Named
@ViewScoped
public class EnderecoController {
	
	@Inject
    private EnderecoService enderecoService;

    private Collection<Endereco> enderecos;
    private Endereco endereco;
    private Boolean isUpdate;

    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.endereco = new Endereco();
            this.enderecos = enderecoService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os endereços"));
        }
    }

    @Transactional
    public void cancel() {
        try {
            this.isUpdate = false;
            this.endereco = new Endereco();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }
    }

    @Transactional
    public void edit(Endereco endereco) {
        try {
            this.isUpdate = true;
            this.endereco = endereco;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar o endereço"));
        }
    }

    @Transactional
    public void delete(Endereco endereco) {
        try {
            enderecoService.excluir(endereco);
            enderecos.remove(endereco);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o endereço"));
        }
    }

    @Transactional
    public void add() {
        try {
            enderecoService.cadastrar(endereco);
            this.enderecos = enderecoService.buscarTodos();
            this.endereco = new Endereco();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o endereço"));
        }
    }

    @Transactional
    public void update() {
        try {
            enderecoService.alterar(this.endereco);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Endereço atualizado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o endereço"));
        }
    }
    
    @Transactional
    public void associarEndereco(Pessoa pessoa) {
        try {
           
            if (endereco != null) {
              
                pessoa.setEndereco(endereco);
                FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Endereço associado à pessoa com sucesso"));
            } else {
                FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Selecione um endereço para associar"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar associar o endereço à pessoa"));
        }
    }

    @Transactional
    public void desassociarEndereco(Pessoa pessoa) {
        try {
            
            pessoa.setEndereco(null);
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Endereço desassociado da pessoa com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar desassociar o endereço da pessoa"));
        }
    }

    public Collection<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Collection<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
}



