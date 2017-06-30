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
import dao.DetalharAtorDAO;
import dao.DetalharFilmeDAO;
import model.Filme;

/**
 * Servlet implementation class ServletDetalhaPessoa
 */
@WebServlet("/paginaIncluirAtor")
public class ServletPaginaIncluirAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaIncluirAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obter parametro
		//Obter uma conexao com o BD
		Connection conexao = Conexao.getConexao();
		//Instanciando DetalhaPessoaDAO
		DetalharAtorDAO dad = new DetalharAtorDAO(conexao);
		//Obter detalhes da Pessoa
		
		//----- Escrevendo a resposta ao cliente -----
		PrintWriter out = response.getWriter();
		
		out.println("<H2>Novo Ator</H2>");
		out.println("<FORM ACTION='incluirAtor'>");
		out.println("Nome: <INPUT TYPE='TEXT' NAME='nome'><BR>");
		out.println("Ano: <INPUT TYPE='TEXT' NAME='ano'><BR>");
		out.println("Cidade de Nascimento: <INPUT TYPE='TEXT' NAME='cidade_nasc'><BR>");
		out.println("<INPUT TYPE='SUBMIT' VALUE='Incluir'>");
		out.println("</FORM></BODY></HTML>");
	}
	
		
	

}

