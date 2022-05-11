package br.com.senaisp.aula15;

import br.com.senaisp.aula15.classes.ConversorTemperatura;

public class ExemploCalculoTemperatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversorTemperatura conv = new ConversorTemperatura();
		try {
			conv.setTipotempOri(1);
			conv.setTipotempDes(2);
			conv.setTemperatura(35.00);
			System.out.println("Temperatura calculada é " + 
					conv.getTemperaturaConvertida());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}

}
