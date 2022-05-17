package br.com.senaisp.aula17.classes;

public class Mamiferos {
	private String Nome;
	private int Idade;
	private String CorPelo;
	//Campo Protegido
	protected int AnoNascimento;
	
	public void Falar() {
		System.out.println("Mamifero falando!");
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getIdade() {
		return Idade;
	}
	public void setIdade(int idade) {
		Idade = idade;
	}
	public String getCorPelo() {
		return CorPelo;
	}
	public void setCorPelo(String corPelo) {
		CorPelo = corPelo;
	}

}
