package br.com.daniel;

import br.com.daniel.classes.Paciente;

public class TestePaciente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente pac = new Paciente();
		for (int intI = 1; intI <= 10; intI++) {
			pac.novo();
			
			pac.setId(intI);
			pac.setNome("Paciente " + intI);
			pac.setEndereco("RUa das ruas " + intI);
			pac.setIdade(35 + intI);
			pac.setEmail("email@com."+intI);
			
			pac.adicionar();
		}
		pac.listar();
	}

}
