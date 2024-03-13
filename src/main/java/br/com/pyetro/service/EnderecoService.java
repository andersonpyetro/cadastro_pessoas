package br.com.pyetro.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.pyetro.dao.generic.IGenericDAO;
import br.com.pyetro.domain.Endereco;
import br.com.pyetro.domain.Pessoa;
import br.com.pyetro.exceptions.DAOException;
import br.com.pyetro.exceptions.MaisDeUmRegistroException;
import br.com.pyetro.exceptions.TableException;
import br.com.pyetro.service.generic.GenericService;


@Stateless
public class EnderecoService extends GenericService<Endereco, Long> implements IEnderecoService {

	@Inject
	public EnderecoService(IGenericDAO<Endereco, Long> dao) {
		super(dao);
		
	}

	@Override
	public Endereco buscaPorCpf(Pessoa pessoa) throws DAOException {
		try {
			return this.dao.consultar(pessoa.getCpf());
		} catch (MaisDeUmRegistroException | TableException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
