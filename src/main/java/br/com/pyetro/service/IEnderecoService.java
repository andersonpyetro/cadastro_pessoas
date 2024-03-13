package br.com.pyetro.service;

import br.com.pyetro.domain.Endereco;
import br.com.pyetro.domain.Pessoa;
import br.com.pyetro.exceptions.DAOException;
import br.com.pyetro.service.generic.IGenericService;

public interface IEnderecoService extends IGenericService<Endereco, Long>{
	
	Endereco buscaPorCpf(Pessoa pessoa) throws DAOException;

}
