package br.com.mcoder.services;

import br.com.mcoder.dao.exceptions.TipoChaveNaoEncontradaException;
import br.com.mcoder.domain.Cliente;

public interface IClienteService {

	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
