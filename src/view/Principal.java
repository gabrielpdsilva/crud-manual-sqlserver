package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Produto;
import persistence.ProdutoDAO;

public class Principal {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Produto produto;
		ProdutoDAO pDao = new ProdutoDAO();
		
		int opc = 0;
		String nome;
		int id;
		double preco;
		
		do {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("OPCOES:\n0- Listar tudo\n1- Pesquisar\n2- Cadastrar\n3- Editar\n4- Excluir\n9- Finalizar"));
			
			switch(opc){
				case 0:
					for(Produto p: pDao.listarTudo()) {
						System.out.println(p.toString());
					}
				break;
				
				case 1:
					id = Integer.parseInt(JOptionPane.showInputDialog("PESQUISAR\nDigite o ID do produto."));
					produto = new Produto(id);
					produto = pDao.pesquisarProduto(produto);
					System.out.println(produto.toString());
				break;
					
				case 2:
					nome = JOptionPane.showInputDialog("CADASTRAR\nDigite o nome do produto.");
					preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto."));
					produto = new Produto(nome, preco);
					pDao.salvarProduto(produto);
				break;
					
				case 3:
					id = Integer.parseInt(JOptionPane.showInputDialog("EDITAR\nDigite o ID do produto."));
					nome = JOptionPane.showInputDialog("Digite o novo nome do produto.");
					preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo preço do produto."));
					produto = new Produto(id, nome, preco);
					pDao.editarProduto(produto);
				break;
					
				case 4:
					id = Integer.parseInt(JOptionPane.showInputDialog("EXCLUIR\nDigite o ID do produto."));
					produto = new Produto(id);
					pDao.excluirProduto(produto);
				break;
				
				case 9:
					JOptionPane.showMessageDialog(null,  "Finalizando...");
				break;
				
				default:
					JOptionPane.showMessageDialog(null,  "Opção inválida.");
			}
		} while (opc != 9);		
	}
}