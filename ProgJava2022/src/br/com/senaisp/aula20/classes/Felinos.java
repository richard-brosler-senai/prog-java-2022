package br.com.senaisp.aula20.classes;

public abstract class Felinos extends Mamiferos {
	public Felinos(String corPele, int idade) {
		super(corPele, idade);
		// TODO Auto-generated constructor stub
	}
	private String raca;

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
}
