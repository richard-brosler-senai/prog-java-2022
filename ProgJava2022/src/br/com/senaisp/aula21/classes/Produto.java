package br.com.senaisp.aula21.classes;

public class Produto {
	private String nome;
	private int qtde;
	private double preco;

	public Produto(String nome, int qtde, double preco) {
		super();
		this.nome = nome;
		this.qtde = qtde;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double precoTotal() {
		return preco * qtde;
	}
}
