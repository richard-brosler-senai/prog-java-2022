package br.com.senaisp.aula06;

import java.util.Locale;
import java.util.Scanner;

public class Aula06Exe04Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp = 1;
		// Scanner irá colocar ponto decimal ao invés de vírgula decimal
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		// While de continuação
		while (intResp != 2) {
			System.out.println("Sistema de cálculo de temperatura");
			System.out.println("1 - Celsius");
			System.out.println("2 - Fahrenheit");
			System.out.println("3 - Kelvin");
			int intTempOri;
			do {
				System.out.println("Temperatura Origem: (1 ou 2 ou 3)");
				intTempOri = sc.nextInt();
			} while (intTempOri != 1 && intTempOri != 2 && intTempOri != 3);
		
			int intTempDes;
			do {
				System.out.println("Temperatura Destino: (1 ou 2 ou 3)");
				intTempDes = sc.nextInt();
			} while (intTempDes != 1 && intTempDes != 2 && intTempDes != 3);
			
			System.out.println("Valor Temperatura a ser convertida:");
			double dblTemperatura = sc.nextDouble();

			double dblTempConv = dblTemperatura;
			// teste de conversão
			switch(intTempOri) {
			case 1: //Celsius origem
				switch(intTempDes) {
				case 2: //Fahreinheit destino
					dblTempConv = dblTemperatura * 9 / 5 + 32;
					break;
				case 3:
					dblTempConv = dblTemperatura + 273;
				}//switch da temperatura destino
				break;
			case 2:
				if (intTempDes == 1) { // testando destino Celsius
					dblTempConv = ( dblTemperatura - 32 ) * 5 / 9;
				} else if (intTempDes == 3) { // testando destino kelvin
					dblTempConv = ( dblTemperatura - 32 ) * 5 / 9 + 273;
				}
				break;
			default:
				if (intTempDes == 1) { // testando destino Celsius
					dblTempConv = dblTemperatura - 273;
				} else if (intTempDes == 2) { // testando destino Fahenheit
					dblTempConv = ( dblTemperatura - 273 ) * 9 / 5 + 32;
				}
			}
			System.out.println("A temperatura calculada final é " + dblTempConv);
			System.out.println("Deseja calcular mais uma temperatura? (1-sim,2-não):");
			intResp = sc.nextInt();
		}
	}

}
