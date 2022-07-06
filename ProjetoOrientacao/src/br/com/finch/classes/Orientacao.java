package br.com.finch.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Orientacao {
	private ConexaoBD conn;
	
	private int id;
	private String palavraChave;
	private String titulo;
	private String texto;
	
	private boolean haErro;
	private String msgErro;
	
	public Orientacao() {
		conn = ConexaoBD.getInstance();
	}
	
	public void novo() {
		id = 0;
		palavraChave = null;
		titulo = null;
		texto = null;
	}
	
	public boolean create() {
		boolean ret = false;
		try {
			conn.conectarBD();
			String sql = "insert into orientacao(palavrachave,titulo,texto) values (?,?,?)";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql, 
						PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, palavraChave);
			stmt.setString(2, titulo);
			stmt.setString(3, texto);
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1);
			conn.desconectarBD();
			ret = true;
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		return ret;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPalavraChave() {
		return palavraChave;
	}
	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isHaErro() {
		return haErro;
	}
	public String getMsgErro() {
		return msgErro;
	}

}
