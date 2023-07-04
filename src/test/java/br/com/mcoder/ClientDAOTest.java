package br.com.mcoder;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.mcoder.dao.ClienteDAO;
import br.com.mcoder.dao.ClienteDaoMock;
import br.com.mcoder.dao.IClienteDAO;
import br.com.mcoder.dao.exceptions.TipoChaveNaoEncontradaException;
import br.com.mcoder.domain.Cliente;

public class ClientDAOTest {
	
	private IClienteDAO clientDao;

	private Cliente client;
	
	public ClientDAOTest() {
		clientDao = new ClienteDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		client = new Cliente();
		client.setCpf(33345566678L);
		client.setNome("Manoel");
		client.setCidade("Bauru");
		client.setEndereco("Rua direita");
		client.setEstado("SP");
		client.setNumero(22);
		client.setTelefone(1488889999L);
		clientDao.cadastrar(client);
	}
	
	@Test
	public void readClient() {
		Cliente clienteConsultado = clientDao.consultar(client.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void createClient() throws TipoChaveNaoEncontradaException {
		client.setCpf(56565656565L);
		Boolean retorno = clientDao.cadastrar(client);
		Assert.assertTrue(retorno);
	}
	
	
	@Test
	public void deleteClient() {
		clientDao.excluir(client.getCpf());
	}
	
	@Test
	public void updateClient() throws TipoChaveNaoEncontradaException {
		client.setNome("Rafael");
		clientDao.alterar(client);
		Assert.assertEquals("Rafael", client.getNome());
	}
	
	@Test
	public void buscarTodos() {
		Collection<Cliente> list = clientDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 1);
	}
}