package com.gmail.islaianemaia.presistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static final String driver = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/bancocjWeb1";
	private static final String usuario = "postgres";
	private static final String senha = "postgres";
	
	public static Connection conectar(){
		Connection con=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,usuario,senha);
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Driver não encontrado");
		} catch(SQLException erro){
			JOptionPane.showMessageDialog(null,"senha ou usuario invalidos");
		}
		
		
		return con;
	}

}
