/**
 * 
 */
package br.com.falves.dao;

import br.com.falves.dao.generic.IGenericDAO;
import br.com.falves.domain.Venda;
import br.com.falves.exceptions.DAOException;
import br.com.falves.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
