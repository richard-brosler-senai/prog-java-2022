package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class Gato extends Felinos implements InFalantes {

	public Gato(String corPele, int idade) {
		super(corPele, idade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void falar() {
		System.out.println("Miauuuuu!");
	}

}
