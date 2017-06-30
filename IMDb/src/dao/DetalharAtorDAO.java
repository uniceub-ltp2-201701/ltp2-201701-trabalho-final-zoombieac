package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Filme;

public class DetalharAtorDAO {
	//Atributos
	private Connection conexao;
	
	//Metodo construtor
	public DetalharAtorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//Metodo que retornar uma reuniao pelo idReuniao
	public Ator getAtor(String id_ator){
		//Criar objetos
		Ator ator = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Detalhar um ator pelo id_ator
		try {
			ps = conexao.prepareStatement("SELECT id_ator, nome, ano, cidade_nasc FROM ator WHERE id_ator =?");
			ps.setInt(1, Integer.parseInt(id_ator));
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ator = new Ator(rs.getInt("id_ator"), rs.getString("nome"), 
						rs.getInt("ano"), rs.getString("cidade_nasc"));	
			}
			
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ator;				
			}
	
	
	//Metodo que retorna os filmes do ator selecionado
	public ArrayList<Filme> getFilmes(String id_ator){
		//Criar objetos
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Obter filmes do ator
		try {
			ps = conexao.prepareStatement("SELECT * FROM filme f, participar p WHERE p.ator_id_ator =? AND p.filme_id_filme = f.id_filme");
			ps.setInt(1, Integer.parseInt(id_ator));
			
			rs = ps.executeQuery();
			
			//Criar arraylist de filmes
			while (rs.next()) {
				Filme f = new Filme(rs.getInt("id_filme"), rs.getString("titulo"), rs.getString("titulo_ingles"), rs.getInt("ano"), rs.getFloat("nota"), rs.getString("duracao"), rs.getString("sinopse"));
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
	