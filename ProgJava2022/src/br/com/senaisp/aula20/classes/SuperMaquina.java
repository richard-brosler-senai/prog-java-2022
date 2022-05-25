package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class SuperMaquina extends Carro implements InFalantes {

	public SuperMaquina(String marca, String modelo, int anoFabricacao, String motor) {
		super(marca, modelo, anoFabricacao, motor);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void falar() {
		System.out.println("Olá, em que posso ajudar?");
	}
	@Override
	public void ligarVeiculo() {
		System.out.println("Supermaquina ligando!");
		//Chama o método do pai
		super.ligarVeiculo();
	}

}
