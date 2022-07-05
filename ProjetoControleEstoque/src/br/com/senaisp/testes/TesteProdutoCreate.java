package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteProdutoCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto prod = new Produto();
		
		prod.setDescricao("Produto 1");
		prod.setSaldo(10);
		prod.setPreco(15.00);
		prod.setLocalEstoque("Prateleira 1");
		
		if (prod.create()) {
			System.out.println("Produto criado com sucesso!");
			System.out.println("ID -> "+ prod.getId());
		} else {
			System.out.println("Ocorreu um erro ao criar o produto!");
			System.out.println(prod.getMsgErro());
		}
	}

}
