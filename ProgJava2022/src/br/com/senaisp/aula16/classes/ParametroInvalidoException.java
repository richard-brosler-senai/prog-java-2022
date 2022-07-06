package br.com.senaisp.aula16.classes;

public class ParametroInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Constructor
	public String teste;
	public ParametroInvalidoException(String arg0) {
		super(arg0);
	}

}
