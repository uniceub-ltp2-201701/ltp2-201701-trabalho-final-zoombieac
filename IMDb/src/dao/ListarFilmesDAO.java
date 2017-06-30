package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class ListarFilmesDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public ListarFilmesDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getFilmes(){
		ArrayList<Filme> listaFilmes =  new ArrayList<Filme>();
		try {
			
			 PreparedStatement ps = null;
			 ResultSet rs = null;
			 
			 ps = conexao.prepareStatement("SELECT * FROM filme");
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()){
				 listaFilmes.add(new Filme(rs.getInt("id_filme"), rs.getString("titulo"), rs.getString("titulo_ingles"), rs.getInt("ano"), rs.getFloat("nota"), 
						 rs.getString("duracao"), rs.getString("sinopse")));
			 }
			 ps.close();
			 rs.close();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaFilmes;
	}

}