package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Genero;

public class ListarGenerosDAO {
	
	private Connection conexao;
	
	//metodo construtor
	
	public ListarGenerosDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Genero> getGenero(){
		ArrayList<Genero> listaGeneros =  new ArrayList<Genero>();
		try {
			
			 PreparedStatement ps = null;
			 ResultSet rs = null;
			 
			 ps = conexao.prepareStatement("SELECT * FROM genero;");
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()){
				 listaGeneros.add(new Genero(rs.getInt("id_genero"), rs.getString("tipo")));
			 }
			 ps.close();
			 rs.close();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaGeneros;
	}

}