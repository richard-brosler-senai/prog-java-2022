package br.com.senaisp.aula32.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class Cliente {
	private int id;
	private String nome;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cpf;
	private String rg;
	private Date data_nasc;
	
	private DateFormat dtFmt;
	private DateFormat dtFmtBD;
	
	private ConexaoBD conn;
	private String cep;
	
	public Cliente() {
		dtFmt = new SimpleDateFormat("dd/MM/yyyy");
		dtFmtBD = new SimpleDateFormat("yyyy-MM-dd");
		conn = ConexaoBD.getInstance();
	}
	
	public void criar() throws SQLException {
		conn.conectarBD();
		String strDtNasc = null;
		if (data_nasc!=null) strDtNasc = dtFmtBD.format(data_nasc);
		String sql = "insert into cliente(nome,endereco,numero,complemento,bairro,cidade,uf,cep,cpf,rg,data_nasc)\r\n"
					+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.getConector().prepareStatement(sql, 
								PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, nome);
		stmt.setString(2, endereco);
		stmt.setString(3, numero);
		stmt.setString(4, complemento);
		stmt.setString(5, bairro);
		stmt.setString(6, cidade);
		stmt.setString(7, uf);
		stmt.setString(8, cep);
		stmt.setString(9, cpf);
		stmt.setString(10, rg);
		stmt.setString(11, strDtNasc);
		//Executando a Query
		int rowsAff = stmt.executeUpdate();
		System.out.println("Linhas afetadas: " + rowsAff);
		//Obtendo o id gerado na inserção do registro
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		//obtendo o valor e passando para o field id
		id = rs.getInt(1);
		System.out.println("ID -> " + id);
		//desconectando do banco de dados
		conn.desconectarBD();
	}
	/**
	 * Esse método de criação não é recomendado utilizar
	 * porque montamos a string de execução inteira.
	 * Se tivermos um campo com preenchimento errado ou nulo
	 * teremos problemas.
	 * Só coloquei esse método para demonstrar como <b>NÃO USAR</b>. rsss
	 * @throws SQLException
	 */
	public void criarNaoUse() throws SQLException {
		conn.conectarBD();
		Statement stmt = conn.getConector().createStatement();
		String strDtNasc = "";
		if (data_nasc!=null) strDtNasc = dtFmtBD.format(data_nasc);
		String sql = "insert into cliente(nome,endereco,numero,complemento,bairro,cidade,uf,cep,cpf,rg,data_nasc)\r\n"
				+ "values ("
						+ "'" + nome + "',"
						+ "'" + endereco + "',"
						+ "'" + numero + "',"
						+ ( complemento == null ? "null," : "'" + complemento + "'," ) 
						+ "'" + bairro + "',"
						+ "'" + cidade + "',"
						+ "'" + uf + "',"
						+ "'" + cep + "',"
						+ "'" + cpf + "',"
						+ "'" + rg + "',"
						+ ( data_nasc == null ? "null" : "'"+strDtNasc+"'" )
						+ ")";
		System.out.println("SQL: " + sql);
		//Executando a inserção de registro
		int rowsAff = stmt.executeUpdate(sql);
		System.out.println("Linhas afetadas: " + rowsAff);
		//Obtendo o ID gerado na inserção do registro
		ResultSet rs = stmt.executeQuery("select last_insert_id();");
		rs.next();
		//pegando o valor do resultado do SQL disparado
		id = rs.getInt(1);
		System.out.println("ID ->" + id);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public void setCep(String string) {
		// TODO Auto-generated method stub
		cep=string;
	}
	
	public boolean ler() throws SQLException, ParseException {
		boolean ret = false;
		conn.conectarBD();
		//Muito cuidado com o select *, se mudar na estrutura do banco
		//a posição da coluna, vai dar problema no programa
		String sql = "select * from cliente where id = ?";
		//Como não será gerado um incremento do id, não usamos a opção
		//generatedKey
		PreparedStatement stmt = conn.getConector().prepareStatement(sql);
		//Atribuindo o id para pesquisar
		stmt.setInt(1, id);
		//Executando a query
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			nome = rs.getString(2); //Coluna 2 - Nome
			endereco = rs.getString(3);
			numero = rs.getString(4);
			complemento = rs.getString(5);
			bairro = rs.getString(6);
			cidade = rs.getString(7);
			uf = rs.getString(8);
			cep = rs.getString(9);
			cpf = rs.getString(10);
			rg = rs.getString(11);
			
			data_nasc = null;
			String strDtNas = rs.getString(12);
			if (strDtNas != null) data_nasc = dtFmtBD.parse(strDtNas);
			
			ret = true;
		}
		return ret;
	}
	
	public void alterar() throws SQLException {
		conn.conectarBD();
		String sql = "update cliente set "
					  + "nome = ?, "
					  + "endereco = ?,"
					  + "numero = ?, "
					  + "complemento = ?, "
					  + "bairro = ?,"
					  + "cidade = ?, "
					  + "uf = ?, "
					  + "cep = ?, "
					  + "cpf = ?, "
					  + "rg = ?,"
					  + "data_nasc = ? "
					  + "where id = ?";
		PreparedStatement stmt = conn.getConector().prepareStatement(sql);
		
		String strDtNasc = null;
		if (data_nasc!=null) strDtNasc = dtFmtBD.format(data_nasc);
		
		stmt.setString(1, nome);
		stmt.setString(2, endereco);
		stmt.setString(3, numero);
		stmt.setString(4, complemento);
		stmt.setString(5, bairro);
		stmt.setString(6, cidade);
		stmt.setString(7, uf);
		stmt.setString(8, cep);
		stmt.setString(9, cpf);
		stmt.setString(10, rg);
		stmt.setString(11, strDtNasc);
		
		stmt.setInt(12, id);
		
		int rowsAff = stmt.executeUpdate();
		System.out.println("Linhas alteradas: " + rowsAff);
		conn.desconectarBD();
	}
	
	public void apagar() throws SQLException {
		conn.conectarBD();
		String sql = "delete from cliente where id = ?";
		PreparedStatement stmt = conn.getConector().prepareStatement(sql);
		
		stmt.setInt(1, id);
		int rowAff = stmt.executeUpdate();
		System.out.println("Linhas apagadas: " + rowAff);
		
		conn.desconectarBD();
	}
	
	public DefaultTableModel listaCliente() throws SQLException {
		DefaultTableModel ret = null;
		conn.conectarBD();
		String sql = "select * from cliente order by id";
		PreparedStatement stmt = conn.getConector().prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		//O Comando abaixo vai retornar informações dos campos com
		//base no Select que foi dado
		ResultSetMetaData rsm = stmt.getMetaData();
		
		String titulos[] = new String[rsm.getColumnCount()];
		//percorrendo as colunas para adicionar aos títulos
		for (int intI=1;intI<=rsm.getColumnCount();intI++) {
			//Vetores começam com índice 0, por isso intI-1
			//A coluna por sua vez, começa com 1
			titulos[intI-1] = rsm.getColumnName(intI);
		}
		//Criando o defaulttablemodel com os títulos
		ret = new DefaultTableModel(titulos,0);
		//Percorrendo os dados do SQL para jogar para o tablemodel
		//Enquanto houver dados, ele percorre
		while(rs.next()) {
			//Definindo o vetor de objetos com a quantidade de colunas
			Object obj[] = new Object[rsm.getColumnCount()];
			//Percorrendo as colunas para setar o conteúdo
			for (int intI=1;intI<=rsm.getColumnCount();intI++) {
				obj[intI-1] = rs.getString(intI);
			}
			//adicionando os dados para o tablemodel
			ret.addRow(obj);
		}
		return ret;
	}
}
