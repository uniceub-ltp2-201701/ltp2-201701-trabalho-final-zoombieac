package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IncluirAtorDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public IncluirAtorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean IncluirAtor(String nome, String ano,  String cidade_nasc){
		PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("INSERT INTO ator(nome,  ano,  cidade_nasc) values(?,?,?)");
			ps.setString(1, nome);
			ps.setInt(2, Integer.parseInt(ano));
			ps.setString(3, cidade_nasc);
			
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
