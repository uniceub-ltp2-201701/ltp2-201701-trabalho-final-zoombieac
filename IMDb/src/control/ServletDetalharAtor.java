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
import dao.DetalharAtorDAO;
import model.Ator;
import model.Filme;;


/**
 * Servlet implementation class ServletDetalharReuniao
 */
@WebServlet("/detalharAtor")
public class ServletDetalharAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar os parametros
		String id_ator = request.getParameter("id_ator");
		//Obter conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a classe DAO
		DetalharAtorDAO dad = new DetalharAtorDAO(conexao);
		//Obter uma ator pelo id_ator
		Ator ator = dad.getAtor(id_ator);
		//Obter filmes do ator pelo id_ator
		ArrayList<Filme> filmes = dad.getFilmes(id_ator);
		//Colocar atributos no request
		request.setAttribute("ator", ator);
		request.setAttribute("filme", filmes);
		//Fazer o RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharAtor.jsp");
		rd.forward(request, response);
	}

}