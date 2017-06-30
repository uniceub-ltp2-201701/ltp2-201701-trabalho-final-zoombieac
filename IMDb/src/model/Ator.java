package model;

public class Ator {
	
	private int id_ator;
	private String nome;
	private int ano;
	private String cidade_nasc;
	private String personagem;
	
	public Ator(int id_ator, String nome, int ano, String cidade_nasc, String personagem) {
		super();
		this.id_ator = id_ator;
		this.nome = nome;
		this.ano = ano;
		this.cidade_nasc = cidade_nasc;
		this.personagem = personagem;
	}
	public String getPersonagem() {
		return personagem;
	}
	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}
	public Ator(int id_ator, String nome, int ano, String cidade_nasc) {
		super();
		this.id_ator = id_ator;
		this.nome = nome;
		this.ano = ano;
		this.cidade_nasc = cidade_nasc;
	}
	public int getId_ator() {
		return id_ator;
	}
	public void setId_ator(int id_ator) {
		this.id_ator = id_ator;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCidade_nasc() {
		return cidade_nasc;
	}
	public void setCidade_nasc(String cidade_nasc) {
		this.cidade_nasc = cidade_nasc;
	}
	
	
	

}
