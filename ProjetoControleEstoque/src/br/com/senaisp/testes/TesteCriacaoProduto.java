package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteCriacaoProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto prod = new Produto();
		prod.novo();
		prod.setDescricao("Produto 1");
		prod.setSaldo(10);
		prod.setPreco(15.00);
		prod.setLocal_estoque("Prateleira 1 esquerda 10");
		if (prod.create()) {
			System.out.println("Produto cadastrado com sucesso!");
			System.out.println("Id do produto ->" + prod.getId());
		} else {
			System.out.println("Ocorreu um erro no cadastro");
			System.out.println("Erros: " + prod.getMsgErro());
		}
	}

}
