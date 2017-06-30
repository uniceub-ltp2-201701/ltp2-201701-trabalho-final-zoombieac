package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Diretor;
import model.Filme;

public class AssociarDiretorAFilmeDAO {
	private Connection conexao;
	
	public AssociarDiretorAFilmeDAO(Connection conexao) {
	      this.conexao = conexao;
		}
	//Metodo para inserir um FILME
			public boolean AssociarDiretorAFilme(String filme_id_filme, String diretor_id_diretor){
				PreparedStatement ps = null;
				boolean adicionar = false;
				
				try {
					ps = conexao.prepareStatement("insert INTO dirigir (filme_id_filme, diretor_id_diretor) values(?, ?);");
					ps.setInt(1, Integer.parseInt(filme_id_filme));
					ps.setInt(2, Integer.parseInt(diretor_id_diretor));
					
					
					ps.executeUpdate();
					ps.close();
					adicionar = true;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return adicionar;
		}
			//-------------------------------------------------------------------------------------------------------------------
			
			//Metodo que retorna diretor de acordo com id_diretor
			public ArrayList<Filme> getAdicionarDiretorAoFilme(String filme_id_filme){
				ArrayList<Filme> AdicionarDiretorAoFilme = new ArrayList<Filme>();
				PreparedStatement ps = null;
				ResultSet rs = null;
				try{
					ps = conexao.prepareStatement("SELECT distinct d.id_diretor, d.nome, f.titulo ,f.id_filme FROM cinema.diretor AS d, cinema.dirigir, cinema.filme AS f WHERE d.id_diretor = dirigir.diretor_id_diretor AND dirigir.filme_id_filme = f.id_filme AND f.id_filme= ? ;");
					ps.setString(1, filme_id_filme);
					rs=ps.executeQuery();
					while(rs.next()){
						Filme adf = new Filme(rs.getInt("diretor_id_diretor"), rs.getInt("filme_id_filme"), rs.getString("nome"), rs.getString("titulo"));
						AdicionarDiretorAoFilme.add(adf);
					}rs.close();
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				return AdicionarDiretorAoFilme;
			}
	}
