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
import dao.ExcluirAtorDAO;

/**
 * Servlet implementation class ServletExcluiContato
 */
@WebServlet("/excluirAtor")
public class ServletExcluirAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar parametros
		String id_ator = request.getParameter("id_ator");
		//Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a DAO
		ExcluirAtorDAO ead = new ExcluirAtorDAO(conexao);
		//Executar a exclusao
		boolean resultado = ead.excluirAtor(id_ator);
		
		//----- Escrevendo a resposta ao cliente -----
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Exclusão de ator</TITLE></HEAD>");
		out.println("<BODY>");
		
		//Verificar se a exclusao foi bem sucedida
		if (resultado) {
			out.println("<H1>Ator excluído com êxito.</H1><br><a href='/IMDb/gerenciarAtores'>Voltar</a>");
		} else {
			out.println("Erro.</H1><br><a href='/IMDb/gerenciarFilmes'>Voltar</a>");
		}
		
		out.println("</BODY></HTML>");		
	}

}
