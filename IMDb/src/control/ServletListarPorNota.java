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
import dao.ListarPorNotaDAO;
import model.Filme;


/**
 * Servlet implementation class ServletListarFilmes
 */
@WebServlet("/listarPorNota")
public class ServletListarPorNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarPorNota() {
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
		ListarPorNotaDAO lpnd = new ListarPorNotaDAO(conexao);
		//Obter todas as reunioes
		ArrayList<Filme> filmes = lpnd.getFilmes();
		//Adicionar objeto nos parametros do request
		request.setAttribute("filme", filmes);
		//Repassar a requisicao para o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarPorNota.jsp");
		rd.forward(request, response);
	}

}
