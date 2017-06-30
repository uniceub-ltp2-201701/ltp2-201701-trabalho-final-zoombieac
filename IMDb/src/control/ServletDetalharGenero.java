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
import dao.DetalharGeneroDAO;
import model.Filme;;


/**
 * Servlet implementation class ServletDetalharReuniao
 */
@WebServlet("/detalharGenero")
public class ServletDetalharGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalharGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar os parametros
		String id_genero = request.getParameter("id_genero");
		//Obter conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a classe DAO
		DetalharGeneroDAO dgd = new DetalharGeneroDAO(conexao);
		//Obter filmes pelo id_genero
		ArrayList<Filme> filmes = dgd.getFilmesPorGenero(id_genero);
		//Colocar atributos no request
		request.setAttribute("filme", filmes);
		//Fazer o RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalharGenero.jsp");
		rd.forward(request, response);
	}

}