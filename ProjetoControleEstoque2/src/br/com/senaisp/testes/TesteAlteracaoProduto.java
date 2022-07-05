package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteAlteracaoProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto prod = new Produto();
		//Setando o id para pesquisar
		prod.setId(1);
		//pesquisando
		if (prod.read()) {
			//Agora podemos alterar
			System.out.println("Produto encontrado");
			//Alterando os dados
			prod.setDescricao("Produto 1 - Alterado");
			prod.setPreco(30.00);
			//executando a Alteração
			if (prod.update()) {
				System.out.println("Alteração efetuada com sucesso!");
			} else {
				System.out.println("Problemas ao alterar!");
				System.out.println("Erro: "+prod.getMsgErro());
			}
		}
	}

}
