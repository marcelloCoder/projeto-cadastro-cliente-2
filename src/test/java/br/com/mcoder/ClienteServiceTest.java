package br.com.mcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.mcoder.dao.ClienteDaoMock;
import br.com.mcoder.dao.IClienteDAO;
import br.com.mcoder.dao.exceptions.TipoChaveNaoEncontradaException;
import br.com.mcoder.dao.generic.IGenericDAO;
import br.com.mcoder.domain.Cliente;
import br.com.mcoder.services.ClienteService;
import br.com.mcoder.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clientService;
	
	private Cliente client;
	
	public ClienteServiceTest() {
		@SuppressWarnings("unchecked")
		IGenericDAO<Cliente, Long> dao = (IGenericDAO<Cliente, Long>) new ClienteDaoMock();
		clientService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		client = new Cliente();
		client.setCpf(33345566678L);
		client.setNome("Manoel");
		client.setCidade("Bauru");
		client.setEndereco("Rua direita");
		client.setEstado("SP");
		client.setNumero(22);
		client.setTelefone(1488889999L);
		
	}
	
	@Test
	public void readClient() {
		Cliente clienteConsultado = clientService.buscarPorCPF(client.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void createClient() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clientService.cadastrar(client);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void deleteClient() {
		clientService.excluir(client.getCpf());
	}
	
	@Test
	public void updateClient() throws TipoChaveNaoEncontradaException {
		client.setNome("Manoel");
		clientService.alterar(client);
		
		Assert.assertEquals("Manoel", client.getNome());
	}
}