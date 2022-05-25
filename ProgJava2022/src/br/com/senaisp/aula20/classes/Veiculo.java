package br.com.senaisp.aula20.classes;

public abstract class Veiculo {
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private String motor;
	
	public Veiculo(String marca, String modelo, int anoFabricacao, String motor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.motor = motor;
	}

	public abstract void ligarVeiculo();
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
}
