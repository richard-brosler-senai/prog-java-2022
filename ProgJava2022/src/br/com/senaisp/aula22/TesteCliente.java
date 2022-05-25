package br.com.senaisp.aula22;

import br.com.senaisp.aula21.classes.Cliente;

public class TesteCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		
		for (int intI=0;intI < 15;intI++) {
			cli.setCodigo(intI + 1);
			cli.setNome("Genérico " + (intI + 1));
			cli.setEndereco("Rua " + (intI + 1));
			cli.adicionar();
		}
		
		cli.listarClientes();
		//Alterar o cliente 5
		cli.setCodigo(5);
		cli.consultar();
		cli.mostrarCliente();
		//Alterando somente o nome dele
		cli.setNome("Genérico 5 Alterado");
		cli.alterar();
		System.out.println("----------------");
		cli.listarClientes();
		System.out.println("----------------");
		System.out.println("Excluindo o cliente 4");
		cli.setCodigo(4);
		cli.consultar();
		cli.mostrarCliente();
		cli.excluir();
		System.out.println("-------------------");
		cli.listarClientes();
		
	}

}
