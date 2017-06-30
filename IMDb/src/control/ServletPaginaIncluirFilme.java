package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.DetalharFilmeDAO;
import model.Filme;

/**
 * Servlet implementation class ServletDetalhaPessoa
 */
@WebServlet("/paginaIncluirFilme")
public class ServletPaginaIncluirFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaIncluirFilme() {
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
		//----- Escrevendo a resposta ao cliente -----
		PrintWriter out = response.getWriter();
		
		out.println("<H2>Novo Filme</H2>");
		out.println("<FORM ACTION='incluirFilme'>");
		out.println("Titulo: <INPUT TYPE='TEXT' NAME='titulo'><BR>");
		out.println("Titulo em inglês: <INPUT TYPE='TEXT' NAME='titulo_ingles'><BR>");
		out.println("Ano de lançamento: <INPUT TYPE='TEXT' NAME='ano'><BR>");
		out.println("Nota: <INPUT TYPE='TEXT' NAME='nota'><BR>");
		out.println("Duração: <INPUT TYPE='TEXT' NAME='duracao'><BR>");
		out.println("Sinopse: <INPUT TYPE='TEXT' NAME='sinopse'><BR>");
		out.println("Gênero: <td><select name='genero_id_genero'>"
				+ "<option value='1'>Ação</option>"
				+ "<option value='2'>Aventura</option>"
				+ "<option value='3'>Ficção Científica</option>"
				+ "<option value='4'>Fantasia</option>"
				+ "<option value='5'>Herói</option>"
				+ "<option value='6'>Romance</option>"
				+ "<option value='7'>Comédia Romântica</option>"
				+ "<option value='8'>Drama</option>"
				+ "<option value='9'>Terror</option>"
				+ "<option value='10'>Suspense</option>"
				+ "<option value='11'>Comédia</option>"
				+ "<option value='12'>Documentário</option>"
				+ "<option value='13'>Biografia</option>"
				+ "<option value='14'>Anime</option></select></td>");
		out.println("<INPUT TYPE='SUBMIT' VALUE='Incluir'>");
		out.println("</FORM></BODY></HTML>");
	}
		}

