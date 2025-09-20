/**
 * 
 */
package br.com.falves;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.falves.dao.ClienteDaoMock;
import br.com.falves.dao.IClienteDAO;
import br.com.falves.domain.Cliente;
import br.com.falves.exceptions.DAOException;
import br.com.falves.exceptions.TipoChaveNaoEncontradaException;
import br.com.falves.services.ClienteService;
import br.com.falves.services.IClienteService;

/**
 * @author rodrigo.pires
 *
 */
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
        cliente.setCpf(12345678910L);
        cliente.setNome("Falves");
        cliente.setCidade("Belo Horizonte");
        cliente.setEnd("Teste");
        cliente.setEstado("MG");
        cliente.setNumero(10);
        cliente.setTel(3199999999L);
        cliente.setQntCartasPokemon(550);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Falves Rafael");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Falves Rafael", cliente.getNome());
	}
}
