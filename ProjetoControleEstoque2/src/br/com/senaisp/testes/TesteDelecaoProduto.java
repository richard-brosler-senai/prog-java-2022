package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteDelecaoProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto prod = new Produto();
		//Setando o id para pesquisar
		prod.setId(1);
		//pesquisando
		if (prod.read()) {
			//Agora podemos excluir
			System.out.println("Produto encontrado");
			//executando a Exclusão
			if (prod.delete()) {
				System.out.println("Exclusão efetuada com sucesso!");
			} else {
				System.out.println("Problemas ao excluir!");
				System.out.println("Erro: "+prod.getMsgErro());
			}
		} else {
			System.out.println("Produto não encontrado!");
		}
	}

}
