package br.com.pyetro.service;


import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.pyetro.dao.PessoaDAO;
import br.com.pyetro.domain.Pessoa;
import br.com.pyetro.exceptions.DAOException;
import br.com.pyetro.exceptions.MaisDeUmRegistroException;
import br.com.pyetro.exceptions.TableException;
import br.com.pyetro.service.generic.GenericService;

@Stateless
public class PessoaService extends GenericService<Pessoa, Long> implements IPessoaService{

	@Inject
	public PessoaService(PessoaDAO pessoaDAO) {
		super(pessoaDAO);
	}

	@Override
	public Pessoa buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {			
			e.printStackTrace();
		}
		return null;
	}

}
