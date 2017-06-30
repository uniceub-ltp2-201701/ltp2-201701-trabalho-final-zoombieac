package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IncluirFilmeDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public IncluirFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean incluirFilme(String titulo, String titulo_ingles,  String ano, String nota, String duracao, String sinopse, String genero_id_genero){
		PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("INSERT INTO filme(titulo,  titulo_ingles,  ano,  nota,  duracao,  sinopse, genero_id_genero) values(?,?,?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, titulo_ingles);
			ps.setInt(3, Integer.parseInt(ano));
			ps.setFloat(4, Float.parseFloat(nota));
			ps.setString(5, duracao);
			ps.setString(6, sinopse);
			ps.setString(7, genero_id_genero);
			
			
			int resultadoUpdate = ps.executeUpdate();
			if(resultadoUpdate == 1){
				resultadoFinal = true;
			}
			else{
				resultadoFinal = false;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return resultadoFinal;
	}

}

	