package model;

public class Produto {
	
	private int id;
	private String nome;
	private double preco;
	
	public Produto(int id, String nome, double preco){
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto(String nome, double preco){
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto() {
		super();
	}
	
	public Produto(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "=====================\nID: " + id + ";\nnome: " + nome + ";\nvalor: R$" + preco + ".\n";
	}
}