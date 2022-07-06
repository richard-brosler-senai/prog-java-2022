package br.com.finch.testes;

import br.com.finch.classes.Orientacao;

public class TesteOrientacaoCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orientacao or = new Orientacao();
		
		or.novo();
		or.setPalavraChave("triagem,subsidios,documentos,");
		or.setTitulo("Fluxo de Documento");
		or.setTexto("Mussum Ipsum, cacilds vidis litro abertis. "
				  + "Nullam volutpat risus nec leo commodo, "
				  + "ut interdum diam laoreet. Sed non "
				  + "consequat odio.Delegadis gente finis, "
				  + "bibendum egestas augue arcu ut est.Nec "
				  + "orci ornare consequat. Praesent lacinia "
				  + "ultrices consectetur. Sed non ipsum "
				  + "felis.Tá deprimidis, eu conheço uma "
				  + "cachacis que pode alegrar sua vidis.");
		if (or.create()) {
			System.out.println("Registro incluído com sucesso!");
		} else {
			System.out.println("Ocorreu um erro!");
			System.out.println(or.getMsgErro());
		}
	}

}
