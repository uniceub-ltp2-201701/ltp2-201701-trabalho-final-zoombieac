package model;

public class Filme {
	
	private int id_filme;
	private String titulo;
	private String titulo_ingles;
	private int ano;
	private float nota;
	private String duracao;
	private String sinopse;
	private int ator_id_ator;
	private int filme_id_filme;
	private String nome;
	private String personagem;
	private String papel;
	private int diretor_id_diretor;
	
	
	
	public Filme(int id_filme, String titulo, String titulo_ingles, int ano, float nota, String duracao, String sinopse) {
		super();
		this.id_filme = id_filme;
		this.titulo = titulo;
		this.titulo_ingles = titulo_ingles;
		this.ano = ano;
		this.nota = nota;
		this.duracao = duracao;
		this.sinopse = sinopse;
	}
	
	
	public Filme(String titulo, int ator_id_ator, int filme_id_filme, String nome, String personagem, String papel) {
		super();
		this.titulo = titulo;
		this.ator_id_ator = ator_id_ator;
		this.filme_id_filme = filme_id_filme;
		this.nome = nome;
		this.personagem = personagem;
		this.papel = papel;
	}
	
	
	public Filme(int diretor_id_diretor, int filme_id_filme, String titulo, String nome) {
		super();
		this.titulo = titulo;
		this.filme_id_filme = filme_id_filme;
		this.nome = nome;
		this.diretor_id_diretor = diretor_id_diretor;
	}


	public int getId_filme() {
		return id_filme;
	}
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo_ingles() {
		return titulo_ingles;
	}
	public void setTitulo_ingles(String titulo_ingles) {
		this.titulo_ingles = titulo_ingles;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	
	}



	public int getAtor_id_ator() {
		return ator_id_ator;
	}



	public void setAtor_id_ator(int ator_id_ator) {
		this.ator_id_ator = ator_id_ator;
	}
	
	
	public int getFilme_id_filme() {
		return filme_id_filme;
	}



	public void setFilme_id_filme(int filme_id_filme) {
		this.filme_id_filme = filme_id_filme;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getPersonagem() {
		return personagem;
	}



	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}



	public String getPapel() {
		return papel;
	}



	public void setPapel(String papel) {
		this.papel = papel;
	}


	public int getDiretor_id_diretor() {
		return diretor_id_diretor;
	}


	public void setDiretor_id_diretor(int diretor_id_diretor) {
		this.diretor_id_diretor = diretor_id_diretor;
	}
	
	
	
	
	
}
