package com.gmail.islaianemaia;

import javax.swing.JOptionPane;

import com.gmail.islaianemaia.persistencia.enditade.Usuario;
import com.gmail.islaianemaia.presistencia.jdbc.UsuDao;




public class TesteUsuDao {

	public static void main(String[] args) {
		
		//testCadastrar();
		//testAlterar();
		testExcluir();
	}

	private static void testCadastrar() {
		Usuario usu = new Usuario();
		
		String nome = JOptionPane.showInputDialog("Digite o seu nome");
		usu.setNome(nome);
		String login = JOptionPane.showInputDialog("Digite o seu login");
		usu.setLogin(login);
		String senha = JOptionPane.showInputDialog("Digite a sua senha");
		usu.setSenha(senha);
		
		UsuDao ud = new UsuDao();
		ud.cadastrar(usu);
	}
	
	private static void testAlterar(){
		
		Usuario usu = new Usuario();
		
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("digite o novo id"));
		usu.setId(id);
		String nome = JOptionPane.showInputDialog("Digite o novo nome");
		usu.setNome(nome);
		String login = JOptionPane.showInputDialog("Digite o novo login");
		usu.setLogin(login);
		String senha = JOptionPane.showInputDialog("Digite a nova senha");
		usu.setSenha(senha);
		
		UsuDao ud = new UsuDao();
		ud.alterar(usu);
	}
	
private static void testExcluir(){
	Usuario usu = new Usuario();
	
	Integer id = Integer.parseInt(JOptionPane.showInputDialog("digite o novo id"));
	usu.setId(id);
	
	UsuDao ud = new UsuDao();
	ud.Excluir(usu);
}
		
		

}
