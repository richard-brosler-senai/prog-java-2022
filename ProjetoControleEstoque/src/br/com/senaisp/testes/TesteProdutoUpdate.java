package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteProdutoUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto prod = new Produto();
		
		prod.setId(5);
		if (prod.read()) {
			prod.setDescricao(prod.getDescricao() + " - Alterado");
			if (prod.update()) {
				System.out.println("Registro alterado com sucesso!");
			} else {
				System.out.println("Ocorreu um erro ao alterar!");
				System.out.println(prod.getMsgErro());
			}
		} else { //else do if prod.read
			if (prod.getHaErro()) {
				System.out.println("Ocorreu um erro na operação Read");
			}
			System.out.println(prod.getMsgErro());
		}
	}

}
