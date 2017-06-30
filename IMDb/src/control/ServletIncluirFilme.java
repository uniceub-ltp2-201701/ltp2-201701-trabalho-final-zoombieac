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
import dao.IncluirFilmeDAO;

/**
 * Servlet implementation class ServletIncluiContato
 */
@WebServlet("/incluirFilme")
public class ServletIncluirFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluirFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar parametros
		String titulo = request.getParameter("titulo");
		String titulo_ingles = request.getParameter("titulo_ingles");
		String ano = request.getParameter("ano");
		String nota = request.getParameter("nota");
		String duracao = request.getParameter("duracao");
		String sinopse= request.getParameter("sinopse");
		String genero_id_genero = request.getParameter("genero_id_genero");
		//Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Criar a DAO
		IncluirFilmeDAO ifd = new IncluirFilmeDAO(conexao);
		//Inclui o contato
		boolean resultado = ifd.incluirFilme(titulo, titulo_ingles, ano, nota, duracao, sinopse, genero_id_genero);
		
		//----- Escrevendo a resposta ao cliente -----
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>INCLUSÃO DE CONTATO</TITLE></HEAD>");
		out.println("<BODY>");
				
		//Verificar se a inclusao foi bem sucedida
		if (resultado) {
			out.println("<H1>Filme incluído.</H1>");
		} else {
			out.println("<H1>Erro ao incluir.</H1>");
		}
				
		out.println("</BODY></HTML>");
	}

}
