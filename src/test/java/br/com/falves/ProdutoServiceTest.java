/**
 * 
 */
package br.com.falves;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.falves.dao.IProdutoDAO;
import br.com.falves.dao.ProdutoDaoMock;
import br.com.falves.domain.Produto;
import br.com.falves.exceptions.DAOException;
import br.com.falves.exceptions.TipoChaveNaoEncontradaException;
import br.com.falves.services.IProdutoService;
import br.com.falves.services.ProdutoService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
        produto.setCor("Preto");
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Falves");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Falves", produto.getNome());
	}
}
