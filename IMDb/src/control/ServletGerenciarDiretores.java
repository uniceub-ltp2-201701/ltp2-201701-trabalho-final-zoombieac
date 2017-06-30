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
import dao.ListarDiretoresDAO;
import model.Diretor;


/**
 * Servlet implementation class ServletListarFilmes
 */
@WebServlet("/gerenciarDiretores")
public class ServletGerenciarDiretores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGerenciarDiretores() {
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
		ListarDiretoresDAO ldd = new ListarDiretoresDAO(conexao);
		//Obter todas as reunioes
		ArrayList<Diretor> diretores = ldd.Diretores();
		//Adicionar objeto nos parametros do request
		request.setAttribute("diretor", diretores);
		//Repassar a requisicao para o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/respostaGerenciarDiretores.jsp");
		rd.forward(request, response);
	}

}
