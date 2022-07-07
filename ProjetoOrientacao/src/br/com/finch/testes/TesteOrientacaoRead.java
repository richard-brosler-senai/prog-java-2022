package br.com.finch.testes;

import br.com.finch.classes.Orientacao;

public class TesteOrientacaoRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orientacao or = new Orientacao();
		
		or.setId(1);
		if (or.read()) {
			System.out.println("Registro encontrado!");
			System.out.println("Palavras chaves: " + or.getPalavraChave());
			System.out.println("Tituto: "+ or.getTitulo());
			System.out.println("Texto: " + or.getTexto());
		} else {
			if (or.isHaErro()) {
				System.out.println("Ocorreu um erro!");
			}
			System.out.println(or.getMsgErro());
		}
	}

}
