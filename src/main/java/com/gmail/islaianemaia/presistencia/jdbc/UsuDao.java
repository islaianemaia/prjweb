package com.gmail.islaianemaia.presistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.gmail.islaianemaia.persistencia.enditade.Usuario;

public class UsuDao {
	
	private Connection con =Conexao.conectar();
	
	public void cadastrar(Usuario usu){
		String sql="insert into usuario (nome,login,senha) values(?,?,?)";
		try {
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, usu.getNome());
		ps.setString(2, usu.getLogin());
		ps.setString(3, usu.getSenha());
		
		ps.execute();
		ps.close();
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "sql invalido");
		}
	}
	
	
	public void alterar(Usuario usu){
		String sql="update usuario set nome=?, login=?, senha=? where id=?";
		
		try {
	      PreparedStatement ps= con.prepareStatement(sql);
	      ps.setString(1, usu.getNome());
	      ps.setString(2, usu.getLogin());
	      ps.setString(3, usu.getSenha());
	      ps.setInt(4, usu.getId());
	      
	      ps.execute();
	      ps.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "sql invalido");
		}
	}
	
	public void Excluir(Usuario usu){
		
		String sql = "delete from usuario where id=?";
		
		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, usu.getId());
			
			ps.execute();
			ps.close();
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "sql invalido");
		}
	}

}
