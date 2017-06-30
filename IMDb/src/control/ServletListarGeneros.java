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
import model.Filme;
import model.Genero;
import dao.ListarFilmesDAO;
import dao.ListarGenerosDAO;


/**
 * Servlet implementation class ServletListarFilmes
 */
@WebServlet("/listarGeneros")
public class ServletListarGeneros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarGeneros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obter um objeto de conexao
		Connection conexao = Conexao.getConexao();
		//Criar um objeto DAO
		ListarGenerosDAO lfpgd = new ListarGenerosDAO(conexao);
		//Obter todas as reunioes
		ArrayList<Genero> generos = lfpgd.getGenero();
		//Adicionar objeto nos parametros do request
		request.setAttribute("genero", generos);
		//Repassar a requisicao para o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarGeneros.jsp");
		rd.forward(request, response);
	}

}

