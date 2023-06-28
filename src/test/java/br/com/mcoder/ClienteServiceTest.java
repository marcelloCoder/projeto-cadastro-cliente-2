package br.com.mcoder;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.mcoder.dao.ClienteDaoMock;
import br.com.mcoder.dao.IClienteDAO;
import br.com.mcoder.domain.Cliente;
import br.com.mcoder.services.ClienteService;
import br.com.mcoder.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
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
		clienteService.salvar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		
		Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
		
	}
	
	@Test
	public void salvarCliente() {
		Boolean retorno = clienteService.salvar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
		
	}
	
	@Test
	public void alterarCliente() {
		cliente.setNome("Arno");
		clienteService.alterar(cliente);
		Assert.assertEquals("Arno", cliente.getNome());

	}


}
