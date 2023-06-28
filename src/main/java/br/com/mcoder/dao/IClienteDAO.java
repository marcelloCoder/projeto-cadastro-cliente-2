package br.com.mcoder.dao;

import br.com.mcoder.domain.Cliente;

public interface IClienteDAO {

	Boolean salvar(Cliente cliente);
	
	Cliente buscarPorCpf(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente);

}
