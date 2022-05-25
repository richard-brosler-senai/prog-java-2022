package br.com.senaisp.aula20.classes;

public class Carro extends Veiculo {
	public Carro(String marca, String modelo, int anoFabricacao, String motor) {
		super(marca, modelo, anoFabricacao, motor);
		// TODO Auto-generated constructor stub
	}
	private String volante;
	
	@Override
	public void ligarVeiculo() {
		System.out.println("Ligando o Carro!");
	}
	
	public String getVolante() {
		return volante;
	}
	public void setVolante(String volante) {
		this.volante = volante;
	}

}
