package br.com.common.classes;

import java.util.ArrayList;
import java.util.List;

public class ConexaoFake {
	private static ConexaoFake instancia;
	private List<Object> listaObjetos;
	
	private ConexaoFake() {
		listaObjetos = new ArrayList<Object>();
	}
	
	public static ConexaoFake getInstance() {
		if (instancia == null) {
			instancia = new ConexaoFake();
		}
		return instancia;
	}
	
	public List<Object> getListaObjetos(){
		return listaObjetos;
	}
}
