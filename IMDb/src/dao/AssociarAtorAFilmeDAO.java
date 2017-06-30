package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class AssociarAtorAFilmeDAO {
	private Connection conexao;
	
	public AssociarAtorAFilmeDAO(Connection conexao) {
	      this.conexao = conexao;
		}
	//Metodo para inserir um FILME
			public boolean AssociarPessoaAFilme(String filme_id_filme, String ator_id_ator, String personagem, String papel){
				PreparedStatement ps = null;
				boolean adicionar = false;
				
				try {
					ps = conexao.prepareStatement("insert INTO participar (filme_id_filme, ator_id_ator, personagem, papel) values( ?, ?, ?, ?);");
					ps.setInt(1, Integer.parseInt(filme_id_filme));
					ps.setInt(2, Integer.parseInt(ator_id_ator));
					ps.setString(3, personagem);
					ps.setString(4, papel);
					
					
					ps.executeUpdate();
					ps.close();
					adicionar = true;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return adicionar;
		}
			//-------------------------------------------------------------------------------------------------------------------
			
			//Metodo que retorna pessoa de acoedo com idpessoa
			public ArrayList<Filme> getAdicionarAtorAoFilme(String filme_id_filme){
				ArrayList<Filme> AdicionarAtorAoFilme = new ArrayList<Filme>();
				PreparedStatement ps = null;
				ResultSet rs = null;
				try{
					ps = conexao.prepareStatement("SELECT distinct a.id_ator, a.nome, f.titulo, p.personagem ,f.id_filme FROM cinema.ator AS a, cinema.participar AS p, cinema.filme AS f WHERE a.id_ator = p.ator_id_ator AND p.filme_id_filme = f.id_filme AND f.id_filme= ? ;");
					ps.setString(1, filme_id_filme);
					rs=ps.executeQuery();
					while(rs.next()){
						Filme apf = new Filme(rs.getString("titulo"), rs.getInt("ator_id_ator"), rs.getInt("filme_id_filme"), rs.getString("nome"), rs.getString("personagem"), rs.getString("papel"));
						AdicionarAtorAoFilme.add(apf);
					}rs.close();
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				return AdicionarAtorAoFilme;
			}
	}
