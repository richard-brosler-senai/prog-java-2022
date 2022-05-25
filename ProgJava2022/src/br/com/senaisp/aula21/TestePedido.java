package br.com.senaisp.aula21;

import br.com.senaisp.aula21.classes.Pedido;
import br.com.senaisp.aula21.classes.Produto;

public class TestePedido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Pedido ped = new Pedido("12345678900");
			ped.adicionarProduto(new Produto("Agua",2,2.5));
			ped.adicionarProduto(new Produto("Miojo",1,3.00));
			ped.adicionarProduto(new Produto("Pão de Queijo",5,3.00));
			
			ped.listarItens();
			
			System.out.println("Total do pedido:" + ped.totalPedido());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
