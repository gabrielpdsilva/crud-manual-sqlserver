package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Produto;

public interface IProdutoDAO {
	
	public void salvarProduto(Produto produto) throws SQLException;
	
	public void editarProduto(Produto produto) throws SQLException;
	
	public void excluirProduto(Produto produto) throws SQLException;
	
	public Produto pesquisarProduto(Produto produto) throws SQLException;
	
	public List<Produto> listarTudo() throws SQLException;

}
