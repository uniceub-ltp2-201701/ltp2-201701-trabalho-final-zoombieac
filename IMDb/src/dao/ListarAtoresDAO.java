package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Filme;

public class ListarAtoresDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public ListarAtoresDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Ator> Atores(){
		ArrayList<Ator> listaAtores =  new ArrayList<Ator>();
		try {
			
			 PreparedStatement ps = null;
			 ResultSet rs = null;
			 
			 ps = conexao.prepareStatement("SELECT * FROM ator");
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()){
				 listaAtores.add(new Ator(rs.getInt("id_ator"), rs.getString("nome"), rs.getInt("ano"), rs.getString("cidade_nasc")));
			 }
			 ps.close();
			 rs.close();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaAtores;
	}

}