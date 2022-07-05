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
		
		cli.setId(6);
		try {
			if (cli.ler()) {
				System.out.println("Nome: " + cli.getNome());
				System.out.println("Endere�o: " + cli.getEndereco());
				System.out.println("Numero: " + cli.getNumero());
				System.out.println("Complemento: " + cli.getComplemento());
				System.out.println("Data Nascimento: " + cli.getData_nasc());
			} else {
				System.out.println("Cliente n�o encontrado!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
