/**
 * 
 */
package br.com.falves.services;

import br.com.falves.dao.IProdutoDAO;
import br.com.falves.domain.Produto;
import br.com.falves.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
