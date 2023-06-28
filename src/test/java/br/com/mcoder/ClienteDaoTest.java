package br.com.mcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.mcoder.dao.ClienteDAO;
import br.com.mcoder.dao.ClienteDaoMock;
import br.com.mcoder.dao.IClienteDAO;
import br.com.mcoder.domain.Cliente;

public class ClienteDaoTest {
	
	private IClienteDAO clienteDao;
	
	private Cliente cliente;
	
	public ClienteDaoTest() {
		clienteDao = new ClienteDaoMock();
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(1231231231L);
		cliente.setCidade("Passos");
		cliente.setEndereco("Sao Francisco");
		cliente.setEstado("MG");
		cliente.setNome("Marcello");
		cliente.setNumero(9);
		cliente.setTelefone(999999999L);
		clienteDao.salvar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		
		
		Cliente clienteConsultado = clienteDao.buscarPorCpf(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() {
		Boolean retorno = clienteDao.salvar(cliente);
		
		Assert.assertTrue(retorno);
	}
	

	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());

	}
	
	@Test
	public void alterarCliente() {
		cliente.setNome("Arno");
		clienteDao.alterar(cliente);
		Assert.assertEquals("Arno", cliente.getNome());

	}

}
