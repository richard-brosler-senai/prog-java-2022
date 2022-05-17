package br.com.senaisp.aula17.classes;

public class Felino extends Mamiferos {
	private String Porte;

	public String getPorte() {
		return Porte;
	}

	public void setPorte(String porte) {
		Porte = porte;
	}
	@Override
	public void Falar() {
		super.Falar(); //Aqui o Mamifero vai falar
		System.out.println("Felino Falando");
	}
}
