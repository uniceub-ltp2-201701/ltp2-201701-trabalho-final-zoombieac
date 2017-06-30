package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Diretor;
import model.Filme;

public class DetalharDiretorDAO {
	//Atributos
	private Connection conexao;
	
	//Metodo construtor
	public DetalharDiretorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//Metodo que retornar uma reuniao pelo idReuniao
	public Diretor getDiretor(String id_diretor){
		//Criar objetos
		Diretor diretor = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Detalhar um ator pelo id_ator
		try {
			ps = conexao.prepareStatement("SELECT * FROM diretor WHERE id_diretor =?");
			ps.setInt(1, Integer.parseInt(id_diretor));
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				diretor = new Diretor(rs.getInt("id_diretor"), rs.getString("nome"), 
						rs.getInt("ano"), rs.getString("cidade_nasc"));	
			}
			
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return diretor;				
			}
	
	
	//Metodo que retorna os filmes do ator selecionado
	public ArrayList<Filme> getFilmes(String id_diretor){
		//Criar objetos
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//Obter filmes do ator
		try {
			ps = conexao.prepareStatement("SELECT * FROM filme f, dirigir d WHERE d.diretor_id_diretor =? AND d.filme_id_filme = f.id_filme");
			ps.setInt(1, Integer.parseInt(id_diretor));
			
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