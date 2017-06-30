package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirAtorDAO {
	private Connection conexao;
	
	public ExcluirAtorDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//Metodo que exclui um filme pelo id_filme
	public boolean excluirAtor(String id_ator){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("DELETE FROM ator WHERE id_ator=?");
			ps.setInt(1, Integer.parseInt(id_ator));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	

}
