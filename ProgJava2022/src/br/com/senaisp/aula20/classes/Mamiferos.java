package br.com.senaisp.aula20.classes;

public abstract class Mamiferos {
	private String corPele;
	private int idade;
	
	public Mamiferos(String corPele, int idade) {
		super();
		this.corPele = corPele;
		this.idade = idade;
	}
	
	public String getCorPele() {
		return corPele;
	}
	public void setCorPele(String corPele) {
		this.corPele = corPele;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
