package com.gmail.islaianemaia;

import java.util.List;

import javax.swing.JOptionPane;

import com.gmail.islaianemaia.persistencia.enditade.Usuario;
import com.gmail.islaianemaia.presistencia.jdbc.UsuDao;




public class TesteUsuDao {



	public static void main(String[] args) {
		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testSalvar();
		//testBuscaId();
		//testBuscaTodos();
		testAutenticar();
	}

	private static void testAutenticar() {
		Usuario usu = new Usuario();
		
		String login = JOptionPane.showInputDialog("Digite o seu login");
		usu.setLogin(login);
		String senha = JOptionPane.showInputDialog("Digite a sua senha");
		usu.setSenha(senha);
		UsuDao ud = new UsuDao();
		Usuario usuario  = ud.autenticar(usu);
		JOptionPane.showMessageDialog(null, usuario);
	}

	private static void testBuscaTodos() {
      String text ="";
     
      UsuDao ud = new UsuDao();
     List<Usuario> lista = ud.BuscaTodos();
     for(Usuario u:lista){
    	 text =text +"\n"+u;
     }
      JOptionPane.showMessageDialog(null,text);
		
	}

	private static void testBuscaId() {
		
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id que deseja buscar"));
		UsuDao ud = new UsuDao();
		 Usuario usuario = ud.buscaId(id);
		 JOptionPane.showMessageDialog(null, usuario);
		
	}

	private static void testSalvar() {
		
		Usuario usu = new Usuario();
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id se deseja alterar ou 0 para cadastrar"));
	    usu.setId(id);
	    String nome= JOptionPane.showInputDialog("Digite o seu nome");
	    usu.setNome(nome);
	    String login = JOptionPane.showInputDialog("Digite o seu login");
	    usu.setLogin(login);
	    String senha =JOptionPane.showInputDialog("Digite a sua senha");
	    usu.setSenha(senha);
	    
	    UsuDao ud = new UsuDao();
	    ud.Salvar(usu);
	    
		
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
