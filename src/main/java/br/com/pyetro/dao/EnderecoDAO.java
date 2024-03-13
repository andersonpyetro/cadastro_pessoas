package br.com.pyetro.dao;

import br.com.pyetro.dao.generic.GenericDAO;
import br.com.pyetro.domain.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco, Long> implements IEnderecoDAO{

	public EnderecoDAO() {
		super(Endereco.class);
	}

}
