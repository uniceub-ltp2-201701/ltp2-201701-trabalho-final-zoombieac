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
import dao.ListarAtoresDAO;
import model.Ator;


/**
 * Servlet implementation class ServletListarFilmes
 */
@WebServlet("/gerenciarAtores")
public class ServletGerenciarAtores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGerenciarAtores() {
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
		ListarAtoresDAO lad = new ListarAtoresDAO(conexao);
		//Obter todas as reunioes
		ArrayList<Ator> atores = lad.Atores();
		//Adicionar objeto nos parametros do request
		request.setAttribute("ator", atores);
		//Repassar a requisicao para o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/respostaGerenciarAtores.jsp");
		rd.forward(request, response);
	}

}
