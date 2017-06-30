package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IncluirGeneroDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public IncluirGeneroDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean IncluirGenero(String tipo){
		PreparedStatement ps = null;
		
		boolean resultadoFinal = false;
		try {
			ps = conexao.prepareStatement("INSERT INTO genero(tipo) values(?)");
			ps.setString(1, tipo);
	
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
