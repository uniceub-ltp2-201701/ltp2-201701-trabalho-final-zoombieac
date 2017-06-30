package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirDiretorDAO {
	private Connection conexao;
	
	public ExcluirDiretorDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//Metodo que exclui um diretor pelo id_diretor
	public boolean excluirDiretor(String id_diretor){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("DELETE FROM diretor WHERE id_diretor=?");
			ps.setInt(1, Integer.parseInt(id_diretor));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	

}
