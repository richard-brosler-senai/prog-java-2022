package br.com.finch.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

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
	
	public boolean read() {
		boolean ret = false;
		try {
			conn.conectarBD();
			String sql = "select palavrachave, titulo, "
					+ "texto from orientacao where id = ?";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			//Verificando se retornou registros
			if (rs.next()) {
				palavraChave = rs.getString(1);
				titulo = rs.getString(2);
				texto = rs.getString(3);
				ret = true;
			} else {
				msgErro = "Registro não encontrado!";
			}
			conn.desconectarBD();
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}		
		return ret;
	}
	
	public DefaultTableModel readByKeyWords(String value) {
		DefaultTableModel ret = null;
		try {
			conn.conectarBD();
			String sql = "select id, palavrachave, titulo, texto "
					+ "from orientacao where palavrachave like ? order by id";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql);
			stmt.setString(1, "%"+value+"%");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsm = stmt.getMetaData();
			//montando o vetor dos títulos da tabela
			String titulos[] = new String[rsm.getColumnCount()];
			for (int intI=1; intI <= rsm.getColumnCount();intI++) {
				titulos[intI-1] = rsm.getColumnName(intI);
			}
			//Criando o defaulttablemodel com os títulos
			ret = new DefaultTableModel(titulos,0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			//percorrendo os registros retornados
			while (rs.next()) {
				//criando o vetor de objetos para inserir na ret
				Object linha[] = new Object[rsm.getColumnCount()];
				//percorrendo as colunas
				for (int intI=1; intI <= rsm.getColumnCount();intI++) {
					linha[intI-1] = rs.getObject(intI);
				}
				ret.addRow(linha);
			}
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		return ret;
	}
	
	public boolean update() {
		boolean ret = false;
		try {
			conn.conectarBD();
			String sql = "update orientacao set palavrachave=?, titulo=?, texto=? where id=?";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql);
			stmt.setString(1, palavraChave);
			stmt.setString(2, titulo);
			stmt.setString(3, texto);
			stmt.setInt(4, id);
			stmt.executeUpdate();
			conn.desconectarBD();
			ret = true;
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		return ret;
	}
	
	public boolean delete() {
		boolean ret = false;
		try {
			conn.conectarBD();
			String sql = "delete from orientacao where id=?";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			conn.desconectarBD();
			ret = true;
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		return ret;
	}
	
	public DefaultTableModel getListaOrientacao() {
		DefaultTableModel ret = null;
		try {
			conn.conectarBD();
			String sql = "select id, palavrachave, titulo, texto "
					+ "from orientacao order by id";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsm = stmt.getMetaData();
			//montando o vetor dos títulos da tabela
			String titulos[] = new String[rsm.getColumnCount()];
			for (int intI=1; intI <= rsm.getColumnCount();intI++) {
				titulos[intI-1] = rsm.getColumnName(intI);
			}
			//Criando o defaulttablemodel com os títulos
			ret = new DefaultTableModel(titulos,0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			//percorrendo os registros retornados
			while (rs.next()) {
				//criando o vetor de objetos para inserir na ret
				Object linha[] = new Object[rsm.getColumnCount()];
				//percorrendo as colunas
				for (int intI=1; intI <= rsm.getColumnCount();intI++) {
					linha[intI-1] = rs.getObject(intI);
				}
				ret.addRow(linha);
			}
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
