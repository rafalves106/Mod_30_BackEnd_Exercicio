/**
 * 
 */
package br.com.falves;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.falves.dao.ClienteDAO;
import br.com.falves.dao.IClienteDAO;
import br.com.falves.domain.Cliente;
import br.com.falves.exceptions.DAOException;
import br.com.falves.exceptions.MaisDeUmRegistroException;
import br.com.falves.exceptions.TableException;
import br.com.falves.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAOTest {
	
	private IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Falves");
		cliente.setCidade("Belo Horizonte");
		cliente.setEnd("Teste");
		cliente.setEstado("MG");
		cliente.setNumero(10);
		cliente.setTel(3199999999L);
        cliente.setQntCartasPokemon(550);
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Falves");
        cliente.setCidade("Belo Horizonte");
        cliente.setEnd("Teste");
        cliente.setEstado("MG");
        cliente.setNumero(10);
        cliente.setTel(3199999999L);
        cliente.setQntCartasPokemon(550);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Falves");
        cliente.setCidade("Belo Horizonte");
        cliente.setEnd("Teste");
        cliente.setEstado("MG");
        cliente.setNumero(10);
        cliente.setTel(3199999999L);
        cliente.setQntCartasPokemon(550);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Falves");
        cliente.setCidade("Belo Horizonte");
        cliente.setEnd("Teste");
        cliente.setEstado("MG");
        cliente.setNumero(10);
        cliente.setTel(3199999999L);
        cliente.setQntCartasPokemon(550);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Falves Rafael");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Falves Rafael", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Falves");
        cliente.setCidade("Belo Horizonte");
        cliente.setEnd("Teste");
        cliente.setEstado("MG");
        cliente.setNumero(10);
        cliente.setTel(3199999999L);
        cliente.setQntCartasPokemon(550);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente cliente1 = new Cliente();
        cliente1.setCpf(10987654321L);
        cliente1.setNome("Lara");
        cliente1.setCidade("Belo Horizonte");
        cliente1.setEnd("Teste");
        cliente1.setEstado("MG");
        cliente1.setNumero(18);
        cliente1.setTel(31888888888L);
        cliente1.setQntCartasPokemon(250);
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertTrue(retorno1);
		
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
}
