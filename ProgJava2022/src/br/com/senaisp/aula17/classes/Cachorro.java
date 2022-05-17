package br.com.senaisp.aula17.classes;

public class Cachorro extends Mamiferos {
	private String Raca;

	public String getRaca() {
		return Raca;
	}

	public void setRaca(String raca) {
		Raca = raca;
	}
	//Polimorfismo
	@Override
	public void Falar() {
		super.Falar(); //Executando a Falar da classe pai
		System.out.println("AU AU AU");
	}

}
