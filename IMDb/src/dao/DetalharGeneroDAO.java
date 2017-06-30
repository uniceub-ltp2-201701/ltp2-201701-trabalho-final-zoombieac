package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Filme;
import model.Genero;

public class DetalharGeneroDAO {
	//Atributos
	private Connection conexao;
	
	//Metodo construtor
	public DetalharGeneroDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	
	//Metodo que retorna os filmes por genero selecionado
	public ArrayList<Filme> getFilmesPorGenero(String id_genero){
		//Criar objetos
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Obter filmes do genero
		try {
			ps = conexao.prepareStatement("SELECT * FROM filme f, genero g WHERE g.id_genero=? AND g.id_genero = f.genero_id_genero");
			ps.setInt(1, Integer.parseInt(id_genero));
			
			rs = ps.executeQuery();
			
			//Criar arraylist de filmes
			while (rs.next()) {
				Filme f = new Filme(rs.getInt("id_filme"), rs.getString("titulo"), rs.getString("titulo_ingles"), rs.getInt("ano"), rs.getFloat("nota"), 
						rs.getString("duracao"), rs.getString("sinopse"));
				filmes.add(f);				
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filmes;
	}
	}
