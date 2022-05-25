package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class Cachorro extends Mamiferos implements InFalantes {
	public Cachorro(String corPele, int idade) {
		super(corPele, idade);
	}
	private String raca;
	
	@Override
	public void falar() {
		System.out.println("AU AU AU");
	}
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}

}
