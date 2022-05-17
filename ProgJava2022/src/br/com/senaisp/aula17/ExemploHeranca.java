package br.com.senaisp.aula17;

import br.com.senaisp.aula17.classes.*;

public class ExemploHeranca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mamiferos mam[] = new Mamiferos[4];
		//Criando um cachorro
		mam[0] = new Cachorro();
		mam[0].setCorPelo("Malhado");
		mam[0].setIdade(5);
		mam[0].setNome("Toto");
		//Cast 
		((Cachorro) mam[0]).setRaca("SRD");
		//Criando um gato
		mam[1] = new Gato();
		mam[1].setCorPelo("Preto");
		mam[1].setIdade(3);
		mam[1].setNome("Gatinho");
		//Cast 
		((Gato) mam[1]).setRaca("SRD");
		((Gato) mam[1]).setPorte("Pequeno");
		//Criando um Humano
		mam[2] = new Humano();
		mam[2].setCorPelo("Loiro");
		mam[2].setIdade(30);
		mam[2].setNome("Jordan");
		//Cast 
		((Humano) mam[2]).setCorPele("Branca");
		//Criando um Mamifero
		mam[3] = new Mamiferos();
		mam[3].setCorPelo("Azul");
		mam[3].setIdade(45);
		mam[3].setNome("Avatar");
		//Aqui não fica visivel um protected
		//mam[3].AnoNascimento = 10;
		for (int intI=0;intI<4;intI++) {
			System.out.println("Nome: "+mam[intI].getNome());
			System.out.println("Cor Pelo: "+mam[intI].getCorPelo());
			System.out.println("Idade: "+mam[intI].getIdade());
			mam[intI].Falar();
			//Testando se é um humano
			if (mam[intI] instanceof Humano) {
				System.out.println("Eu sou um Humano");
				//Se quiser chamar um método específico
				//((Humano) mam[intI]).Andando();
			}

			System.out.println("--------------------");
		}
		
	}

}
