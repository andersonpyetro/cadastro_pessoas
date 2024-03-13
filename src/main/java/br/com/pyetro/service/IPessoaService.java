package br.com.pyetro.service;

import br.com.pyetro.domain.Pessoa;
import br.com.pyetro.exceptions.DAOException;
import br.com.pyetro.service.generic.IGenericService;

public interface IPessoaService extends IGenericService<Pessoa, Long>{
	
	Pessoa buscarPorCPF(Long cpf) throws DAOException;

}
