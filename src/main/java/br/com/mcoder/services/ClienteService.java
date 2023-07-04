package br.com.mcoder.services;


import br.com.mcoder.domain.Cliente;
import br.com.mcoder.dao.ClienteDAO;
import br.com.mcoder.dao.IClienteDAO;
import br.com.mcoder.dao.exceptions.TipoChaveNaoEncontradaException;
import br.com.mcoder.dao.generic.IGenericDAO;
import br.com.mcoder.domain.Cliente;
import br.com.mcoder.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IGenericDAO<Cliente, Long> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	private IClienteDAO clienteDAO;
	
	

	@Override
	public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException {
		return clienteDAO.cadastrar(cliente);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}

	@Override
	public void excluir(Long cpf) {
		clienteDAO.excluir(cpf);
	}

	@Override
	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
		clienteDAO.alterar(cliente);
	}

}