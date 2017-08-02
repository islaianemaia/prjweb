package com.gmail.islaianemaia.presistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void Salvar(Usuario usu){
		
		if(usu.getId()!=null && usu.getId()>0){
			alterar(usu);
		}else{
			cadastrar(usu);
		}
	}
	
	public Usuario buscaId(Integer id){
		String sql="select * from usuario where id=?";
		
		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resu =ps.executeQuery();
			if(resu.next()){
				Usuario usu = new Usuario();
				usu.setId(resu.getInt("id"));
				usu.setNome(resu.getString("nome"));
				usu.setLogin(resu.getString("login"));
				usu.setSenha(resu.getString("senha"));
				return usu;
			}
			
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "SQL inválido");
		}
		return null;
	}
	
	public List<Usuario> BuscaTodos(){
		String sql = "select * from usuario order by id";
		List<Usuario> lista= new ArrayList<Usuario>();
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet resu = ps.executeQuery();
			while(resu.next()){
				Usuario usu = new Usuario();
				usu.setId(resu.getInt("id"));
				usu.setNome(resu.getString("nome"));
				usu.setLogin(resu.getString("login"));
				usu.setSenha(resu.getString("senha"));
				lista.add(usu);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "SQL inválido");
		}
		return lista;
	}
	
	public Usuario autenticar(Usuario usu){
		String sql="select * from usuario where login=? and senha=?";
		
		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, usu.getLogin());
			ps.setString(2, usu.getSenha());
			
			ResultSet resu = ps.executeQuery();
			if(resu.next()){
			Usuario usuario = new Usuario();
			usuario.setId(resu.getInt("id"));
			usuario.setNome(resu.getString("nome"));
			usuario.setLogin(resu.getString("login"));
			usuario.setSenha(resu.getString("senha"));
			 return usuario;
			}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "SQL inválido");
		}
		
		return null;
	}

}
