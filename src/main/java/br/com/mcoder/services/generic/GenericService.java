package br.com.mcoder.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.mcoder.dao.exceptions.TipoChaveNaoEncontradaException;
import br.com.mcoder.dao.generic.IGenericDAO;
import br.com.mcoder.domain.Cliente;
import br.com.mcoder.domain.Persistente;

public abstract class GenericService<T extends Persistente, E extends Serializable> implements IGenericService<T, E> {

	protected IGenericDAO<T, E> dao;

	public GenericService(IGenericDAO<T, E> dao) {
		this.dao = dao;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(E valor) {
		this.dao.excluir(valor);
	}

	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException {
		this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) {
		return this.dao.consultar(valor);
	}

	@Override
	public Collection<T> buscarTodos() {
		return this.dao.buscarTodos();
	}



}
