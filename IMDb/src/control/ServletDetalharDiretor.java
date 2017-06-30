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
import dao.DetalharDiretorDAO;
import model.Ator;
import model.Diretor;
import model.Filme;;


/**
 * Servlet implementation class ServletDetalharReuniao
 */
@WebServlet("/detalharDiretor")
public class ServletDetalharDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharDiretor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar os parametros
		String id_diretor = request.getParameter("id_diretor");
		//Obter conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a classe DAO
		DetalharDiretorDAO ddd = new DetalharDiretorDAO(conexao);
		//Obter uma ator pelo id_ator
		Diretor diretor = ddd.getDiretor(id_diretor);
		//Obter filmes do diretor pelo id_diretor
		ArrayList<Filme> filmes = ddd.getFilmes(id_diretor);
		//Colocar atributos no request
		request.setAttribute("diretor", diretor);
		request.setAttribute("filme", filmes);
		//Fazer o RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharDiretor.jsp");
		rd.forward(request, response);
	}

}