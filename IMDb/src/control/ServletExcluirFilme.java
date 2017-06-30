package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ExcluirFilmeDAO;

/**
 * Servlet implementation class ServletExcluiContato
 */
@WebServlet("/excluirFilme")
public class ServletExcluirFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar parametros
		String id_filme = request.getParameter("id_filme");
		//Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a DAO
		ExcluirFilmeDAO efd = new ExcluirFilmeDAO(conexao);
		//Executar a exclusao
		boolean resultado = efd.excluirFilme(id_filme);
		
		//----- Escrevendo a resposta ao cliente -----
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Exclusão de filme</TITLE></HEAD>");
		out.println("<BODY>");
		
		//Verificar se a exclusao foi bem sucedida
		if (resultado) {
			out.println("<H1>Filme excluído com êxito.</H1><br><a href='/IMDb/gerenciarFilmes'>Voltar</a>");
		} else {
			out.println("Erro.</H1><br><a href='/IMDb/gerenciarFilmes'>Voltar</a>");
		}
		
		out.println("</BODY></HTML>");		
	}

}

