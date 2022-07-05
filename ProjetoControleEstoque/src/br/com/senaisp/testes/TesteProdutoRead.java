package br.com.senaisp.testes;

import br.com.senaisp.classes.Produto;

public class TesteProdutoRead {
  public static void main(String[] args) {
	  Produto prod = new Produto();
	  
	  prod.setId(5);
	  
	  if (prod.read()) {
		  System.out.println("Produto encontrado!");
		  System.out.println("Descrição: " + prod.getDescricao());
		  System.out.println("Saldo: " + prod.getSaldo());
		  System.out.println("Preço: " + prod.getPreco());
		  System.out.println("Local Estoque: "+ prod.getLocalEstoque());
	  } else {
		  if (prod.getHaErro()) {
			  System.out.println("Ocorreu um erro no Banco de dados");
		  }
		  System.out.println(prod.getMsgErro());
	  }
  }
}
