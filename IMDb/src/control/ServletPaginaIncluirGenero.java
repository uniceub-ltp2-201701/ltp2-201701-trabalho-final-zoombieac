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
import dao.DetalharGeneroDAO;

/**
 * Servlet implementation class ServletDetalhaPessoa
 */
@WebServlet("/paginaIncluirGenero")
public class ServletPaginaIncluirGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaIncluirGenero() {
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
		DetalharGeneroDAO dgd = new DetalharGeneroDAO(conexao);
		//Obter detalhes da Pessoa
		
		//----- Escrevendo a resposta ao cliente -----
		PrintWriter out = response.getWriter();
		
		out.println("<H2>Novo Gênero</H2>");
		out.println("<FORM ACTION='incluirGenero'>");
		out.println("Nome: <INPUT TYPE='TEXT' NAME='tipo'><BR>");
		out.println("<INPUT TYPE='SUBMIT' VALUE='Incluir'>");
		out.println("</FORM></BODY></HTML>");
	}
	
		
	

}
