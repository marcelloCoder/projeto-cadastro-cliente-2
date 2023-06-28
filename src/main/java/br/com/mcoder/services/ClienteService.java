package br.com.mcoder.services;

import br.com.mcoder.dao.ClienteDAO;
import br.com.mcoder.dao.IClienteDAO;
import br.com.mcoder.domain.Cliente;

public class ClienteService implements IClienteService{
	
	private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Boolean salvar(Cliente cliente) {
		return clienteDAO.salvar(cliente);
		
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		// TODO Auto-generated method stub
		return clienteDAO.buscarPorCpf(cpf);
	}

	@Override
	public void excluir(Long cpf) {
		// TODO Auto-generated method stub
		clienteDAO.excluir(cpf);
		
	}

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDAO.alterar(cliente);
		
	}

}
