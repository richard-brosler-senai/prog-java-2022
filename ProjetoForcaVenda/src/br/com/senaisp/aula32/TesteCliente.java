package br.com.senaisp.aula32;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import br.com.senaisp.aula32.classes.Cliente;

public class TesteCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		//*
		cli.setNome("Roberto");
		cli.setEndereco("Rua das Ruas");
		cli.setNumero("S/N");
		cli.setBairro("Centro");
		cli.setCidade("Bauru");
		cli.setUf("SP");
		cli.setCep("17054-000");
		cli.setCpf("222.222.222-22");
		cli.setRg("22.222.222-2");
		
		try {
			//cli.criarNaoUse();
			cli.criar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//*/
		/*
		cli.setId(6);
		try {
			if (cli.ler()) {
				System.out.println("Nome: " + cli.getNome());
				System.out.println("Endereço: " + cli.getEndereco());
				System.out.println("Numero: " + cli.getNumero());
				System.out.println("Complemento: " + cli.getComplemento());
				System.out.println("Data Nascimento: " + cli.getData_nasc());
				
				/ *
				cli.setNome(cli.getNome() + " - Alterado");
				cli.setComplemento("Complemento colocado");
				cli.alterar();
				* /
				System.out.println("Confirma a exclusão? (Sim/Não)");
				Scanner scn = new Scanner(System.in);
				String conf = scn.nextLine();
				if (conf.equalsIgnoreCase("Sim")) {
					cli.apagar();
					System.out.println("Registro apagado com sucesso!");
				}
				scn.close();
				
			} else {
				System.out.println("Cliente não encontrado!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
