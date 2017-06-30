package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirFilmeDAO {
	private Connection conexao;
	
	public ExcluirFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//Metodo que exclui um filme pelo id_filme
	public boolean excluirFilme(String id_filme){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("DELETE FROM filme WHERE id_filme=?");
			ps.setInt(1, Integer.parseInt(id_filme));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	

}
