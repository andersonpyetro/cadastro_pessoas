package br.com.pyetro.dao;

import br.com.pyetro.dao.generic.GenericDAO;
import br.com.pyetro.domain.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Long> implements IPessoaDAO {
	
	public PessoaDAO() {
		super(Pessoa.class);
	}

}
