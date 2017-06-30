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
import dao.IncluirGeneroDAO;

/**
 * Servlet implementation class ServletIncluiContato
 */
@WebServlet("/incluirGenero")
public class ServletIncluirGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluirGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar parametros
		String tipo = request.getParameter("tipo");
		//Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a DAO
		IncluirGeneroDAO igd = new IncluirGeneroDAO(conexao);
		//Inclui o contato
		boolean resultado = igd.IncluirGenero(tipo);
		
		//----- Escrevendo a resposta ao cliente -----
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Inclusão de Genero</TITLE></HEAD>");
		out.println("<BODY>");
				
		//Verificar se a inclusao foi bem sucedida
		if (resultado) {
			out.println("<H1>Genero incluído</H1>");
		} else {
			out.println("<H1>Erro ao incluir</H1>");
		}
				
		out.println("</BODY></HTML>");
	}

}
