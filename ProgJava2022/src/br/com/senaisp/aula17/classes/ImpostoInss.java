package br.com.senaisp.aula17.classes;

public class ImpostoInss extends Imposto {
	
	@Override
	public double calcularImposto() {
		double dblRet=0, dblBC = getBaseCalculo();
		double dblTab[][] = {{ 0.00,    1212.00,  7.5 },
				             { 1212.01, 2427.35,  9.00 },
				             { 2427.36, 3641.03, 12.00 },
				             { 3641.04, 7087.22, 14.00 }
				            };
		
		for (int intI=0;intI<4;intI++) {
			             //0.00                     //1212.00
			if ( dblBC>=dblTab[intI][0] && dblBC<=dblTab[intI][1] ) {
				dblRet += Math.round(( dblBC - dblTab[intI][0] ) * dblTab[intI][2]) 
							/ 100.00;
			} else if (dblBC > dblTab[intI][1]) {
				dblRet += Math.round(( dblTab[intI][1] - dblTab[intI][0]) * 
							dblTab[intI][2]) / 100.00;
			} else {
				break;
			}
		}
		/*
		//Testes para o calculo do imposto sem for
		//Primeira faixa
		if (dblBC>=0 && dblBC<=1212.00) {
			dblRet += ( dblBC - 0.00 ) * 7.5 / 100.00;
		} else if (dblBC > 1212.00) {
			dblRet += ( 1212.00 - 0.00) * 7.5 / 100.00;
		}
		//Segunda faixa
		if (dblBC>=1212.01 && dblBC<=2427.35) {
			dblRet += ( dblBC - 1212.01 ) * 9.00 / 100.00;
		} else if (dblBC > 2427.35) {
			dblRet += ( 2427.35 - 1212.01 ) * 9.00 / 100.00;
		}
		//Terceira faixa
		if (dblBC>=2427.36 && dblBC<=3641.03 ) {
			dblRet += ( dblBC - 2427.36 ) * 12.00 / 100.00;
		} else if (dblBC > 3641.03) {
			dblRet += ( 3641.03 - 2427.36 ) * 12.00 / 100.00;
		}
		//Quarta faixa
		if (dblBC>=3641.04 && dblBC<=7087.22 ) {
			dblRet += ( dblBC - 3641.04 ) * 14.00 / 100.00;
		} else if (dblBC > 7087.22) {
			dblRet += ( 7087.22 - 3641.04 ) * 14.00 / 100.00;
		}
		*/
		return dblRet;
	}

}
