package br.com.common.classes;

import java.util.ArrayList;
import java.util.List;

public class ConexaoFake {
	private static ConexaoFake instancia;
	private List<ClasseBase> listaObjetos;
	
	private ConexaoFake() {
		listaObjetos = new ArrayList<ClasseBase>();
	}
	
	public static ConexaoFake getInstance() {
		if (instancia == null) {
			instancia = new ConexaoFake();
		}
		return instancia;
	}
	
	public List<ClasseBase> getListaObjetos(){
		return listaObjetos;
	}
}
