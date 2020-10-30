package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO implements IProdutoDAO {
	
	private Connection c;
	
	public ProdutoDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gDao = new GenericDAO();
		c = gDao.getConnection();
	}

	@Override
	public void salvarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO produtos(nome, preco) VALUES(?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,  produto.getNome());
		ps.setDouble(2,  produto.getPreco());
		ps.execute();
		ps.close();
	}

	@Override
	public void editarProduto(Produto produto) throws SQLException {
		String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,  produto.getNome());
		ps.setDouble(2,  produto.getPreco());
		ps.setInt(3, produto.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluirProduto(Produto produto) throws SQLException {
		String sql = "DELETE produtos WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,  produto.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public Produto pesquisarProduto(Produto produto) throws SQLException {
		String sql = "SELECT id, nome, preco FROM produtos WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			produto.setId(rs.getInt("id"));
			produto.setNome(rs.getString("nome"));
			produto.setPreco(rs.getDouble("preco"));
		}
		rs.close();
		ps.close();
		return produto;
	}

	@Override
	public List<Produto> listarTudo() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT id, nome, preco FROM produtos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Produto produto = new Produto();
			produto.setId(rs.getInt("id"));
			produto.setNome(rs.getString("nome"));
			produto.setPreco(rs.getDouble("preco"));
			produtos.add(produto);
		}
		rs.close();
		ps.close();
		
		return produtos;
	}
}