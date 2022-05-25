package br.com.senaisp.aula20.classes;

public class Moto extends Veiculo {
	public Moto(String marca, String modelo, int anoFabricacao, String motor) {
		super(marca, modelo, anoFabricacao, motor);
		// TODO Auto-generated constructor stub
	}
	private String manopla;
	
	@Override
	public void ligarVeiculo() {
		// TODO Auto-generated method stub
		System.out.println("Ligando a Moto");
	}
	
	public String getManopla() {
		return manopla;
	}
	public void setManopla(String manopla) {
		this.manopla = manopla;
	}

}
