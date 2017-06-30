package model;

public class Diretor {
	
	private int id_diretor;
	private String nome;
	private int ano;
	private String cidade_nasc;
	
	public Diretor(int id_diretor, String nome, int ano, String cidade_nasc) {
		super();
		this.id_diretor = id_diretor;
		this.nome = nome;
		this.ano = ano;
		this.cidade_nasc = cidade_nasc;
	}
	public int getId_diretor() {
		return id_diretor;
	}
	public void setId_diretor(int id_diretor) {
		this.id_diretor = id_diretor;
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
