package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Diretor;
import model.Filme;

public class ListarDiretoresDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public ListarDiretoresDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Diretor> Diretores(){
		ArrayList<Diretor> listaDiretores =  new ArrayList<Diretor>();
		try {
			
			 PreparedStatement ps = null;
			 ResultSet rs = null;
			 
			 ps = conexao.prepareStatement("SELECT * FROM diretor");
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()){
				 listaDiretores.add(new Diretor(rs.getInt("id_diretor"), rs.getString("nome"), rs.getInt("ano"), rs.getString("cidade_nasc")));
			 }
			 ps.close();
			 rs.close();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaDiretores;
	}

}