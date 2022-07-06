package br.com.senaisp.aula16.classes;

public class Clientes {
	private int Codigo;
	private String Nome;
	private String Endereco;
	
	public int getCodigo() {
		return Codigo;
	}
	/**
	 * Setter para Código. Deverá ser entre 1 e 100.
	 * @param codigo Informar codigo entre 1 e 100.
	 * @throws ParametroInvalidoException Caso não seja 
	 * informado codigo de 1 a 100 ocorerrá um erro.
	 */
	public void setCodigo(int codigo) throws ParametroInvalidoException {
		if (codigo<=0 || codigo>100) {
			throw new 
			ParametroInvalidoException(
					"Código deverá ser entre 1 e 100");
		}
		Codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	/**
	 * Setter para nome. Deverá ter pelo menos 3 caracteres.
	 * @param nome Informar nome com pelo menos 3 caracteres.
	 * @throws ParametroInvalidoException Caso seja informado
	 * nome com menos de 3 caracteres ocorrerá um erro. 
	 */
	public void setNome(String nome) throws ParametroInvalidoException {
		if (nome.length()<3) {
			throw new ParametroInvalidoException(
					"Nome deve ter pelo menos 3 letras!");
		}
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	/**
	 * Setter para o Endereço. Deve conter pelo menos 3 caracteres.
	 * @param endereco Informar o endereço com pelo menos 3 caracteres.
	 * @throws ParametroInvalidoException Caso seja informado endereço
	 * com menos de 3 caracteres ocorerrá um erro.
	 */
	public void setEndereco(String endereco) throws ParametroInvalidoException {
		if (endereco.length()<3) {
			throw new ParametroInvalidoException(
				"Endereço deve ter pelo menos 3 letras");
		}
		Endereco = endereco;
	}
	
}
