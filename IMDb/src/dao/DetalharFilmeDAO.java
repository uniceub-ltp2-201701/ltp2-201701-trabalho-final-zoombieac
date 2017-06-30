package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Diretor;
import model.Filme;
import model.Genero;

public class DetalharFilmeDAO {
	//Atributos
	private Connection conexao;
	
	//Metodo construtor
	public DetalharFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//Metodo que retornar uma reuniao pelo idReuniao
	public Filme getFilme(String id_filme){
		//Criar objetos
		Filme filme = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Obter dados de um filme pelo id_filme
		try {
			ps = conexao.prepareStatement("SELECT * FROM filme WHERE id_filme =?");
			ps.setInt(1, Integer.parseInt(id_filme));
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				filme = new Filme(rs.getInt("id_filme"), rs.getString("titulo"), 
						rs.getString("titulo_ingles"), rs.getInt("ano"), rs.getFloat("nota"), rs.getString("duracao"), rs.getString("sinopse"));	
			}
			
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filme;				
	}
	
	
	//Metodo que retorna os atores do filme selecionado
	public ArrayList<Ator> getAtores(String id_filme){
		//Criar objetos
		ArrayList<Ator> atores = new ArrayList<Ator>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Obter atores do filme
		try {
			ps = conexao.prepareStatement("SELECT * FROM ator a, participar p WHERE p.filme_id_filme =? AND p.ator_id_ator = a.id_ator");
			ps.setInt(1, Integer.parseInt(id_filme));
			
			rs = ps.executeQuery();
			
			//Criar arraylist de participantes
			while (rs.next()) {
				Ator a = new Ator(rs.getInt("id_ator"), rs.getString("nome"), rs.getInt("ano"), rs.getString("cidade_nasc"), rs.getString("personagem"));
				atores.add(a);				
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return atores;
	}
	
	
	//Metodo que retorna o diretor do filme selecionado
	public ArrayList<Diretor> getDiretores(String id_filme){
		//Criar objetos
		ArrayList<Diretor> diretores = new ArrayList<Diretor>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Obter atores do filme
		try {
			ps = conexao.prepareStatement("SELECT * FROM diretor, dirigir WHERE dirigir.filme_id_filme =? AND dirigir.diretor_id_diretor = diretor.id_diretor");
			ps.setInt(1, Integer.parseInt(id_filme));
			
			rs = ps.executeQuery();
			
			//Criar arraylist de participantes
			while (rs.next()) {
				Diretor d = new Diretor(rs.getInt("id_diretor"), rs.getString("nome"), rs.getInt("ano"), rs.getString("cidade_nasc"));
				diretores.add(d);				
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return diretores;
	}
	//Metodo que retorna o generos do filme
		public ArrayList<Genero> getGeneroDesseFilme(String id_filme){
			//Criar objetos
			ArrayList<Genero> genero = new ArrayList<Genero>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			//Obter genero do filme
			try {
				ps = conexao.prepareStatement("SELECT * FROM genero g, filme f WHERE f.id_filme =? AND f.genero_id_genero = g.id_genero");
				ps.setInt(1, Integer.parseInt(id_filme));
				
				rs = ps.executeQuery();
				
				//Criar arraylist de participantes
				while (rs.next()) {
					Genero g = new Genero(rs.getInt("id_genero"), rs.getString("tipo"));
					genero.add(g);				
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return genero;
		}
		
}
		
	
	
	
	

	
	
	
	
	
