package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.DetalharFilmeDAO;
import model.Ator;
import model.Diretor;
import model.Filme;
import model.Genero;;


/**
 * Servlet implementation class ServletDetalharReuniao
 */
@WebServlet("/detalharFilme")
public class ServletDetalharFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar os parametros
		String id_filme = request.getParameter("id_filme");
		//Obter conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a classe DAO
		DetalharFilmeDAO dfd = new DetalharFilmeDAO(conexao);
		//Obter detalhes do filme pelo id_filme
		Filme filme = dfd.getFilme(id_filme);
		//Obter atores do filme por id_filme
		ArrayList<Ator> atores = dfd.getAtores(id_filme);
		//Obter atores do filme por id_filme
		ArrayList<Diretor> diretores = dfd.getDiretores(id_filme);
		//Obter genero do filme pelo id_filme
		ArrayList<Genero> genero = dfd.getGeneroDesseFilme(id_filme);
		//Colocar atributos no request
		request.setAttribute("filme", filme);
		request.setAttribute("diretor", diretores);
		request.setAttribute("ator", atores);
		request.setAttribute("genero", genero);
		//Fazer o RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharFilme.jsp");
		rd.forward(request, response);
	}

}
