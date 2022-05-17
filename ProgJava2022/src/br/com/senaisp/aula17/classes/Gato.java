package br.com.senaisp.aula17.classes;

public class Gato extends Felino {
	private String Raca;

	public String getRaca() {
		return Raca;
	}

	public void setRaca(String raca) {
		Raca = raca;
	}
	@Override
	public void Falar() {
		//Aqui fica visivel o protected porque é descendente do Mamife*ro
		AnoNascimento = 2000;
		super.Falar();
		System.out.println("MIAUUUU!");
	}
}
