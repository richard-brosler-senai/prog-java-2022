package br.com.senaisp.aula32.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	private static ConexaoBD instancia;
	
	private static final String DB_DRIVER = "mysql";
	private static final String DB_DATABASE = "prog_java_2022";
	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_USER = "root";
	private static final String DB_PASS = "Sen@i2021*";
	
	private Connection conector;
	
	private String strConn;
	private String dbUser;
	private String dbPass;
	
	private ConexaoBD() {
		// jdbc:mysql://localhost:3306/prog_java_2022
		strConn = "jdbc:" + DB_DRIVER + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_DATABASE;
		dbUser = DB_USER;
		dbPass = DB_PASS;
	}
	
	public static synchronized ConexaoBD getInstance() {
		if (instancia == null) {
			instancia = new ConexaoBD();
		}
		return instancia;
	}
	
	public void conectarBD() throws SQLException {
		conector = null;
		conector = DriverManager.getConnection(getStrConn(), 
					getDbUser(), getDbPass());
	}
	
	public void desconectarBD() throws SQLException {
		if (conector!=null) conector.close();
		conector = null;
	}

	public String getStrConn() {
		return strConn;
	}

	public void setStrConn(String strConn) {
		this.strConn = strConn;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPass() {
		return dbPass;
	}

	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	public Connection getConector() {
		return conector;
	}

}
