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
		out.println("Titulo em ingl�s: <INPUT TYPE='TEXT' NAME='titulo_ingles'><BR>");
		out.println("Ano de lan�amento: <INPUT TYPE='TEXT' NAME='ano'><BR>");
		out.println("Nota: <INPUT TYPE='TEXT' NAME='nota'><BR>");
		out.println("Dura��o: <INPUT TYPE='TEXT' NAME='duracao'><BR>");
		out.println("Sinopse: <INPUT TYPE='TEXT' NAME='sinopse'><BR>");
		out.println("G�nero: <td><select name='genero_id_genero'>"
				+ "<option value='1'>A��o</option>"
				+ "<option value='2'>Aventura</option>"
				+ "<option value='3'>Fic��o Cient�fica</option>"
				+ "<option value='4'>Fantasia</option>"
				+ "<option value='5'>Her�i</option>"
				+ "<option value='6'>Romance</option>"
				+ "<option value='7'>Com�dia Rom�ntica</option>"
				+ "<option value='8'>Drama</option>"
				+ "<option value='9'>Terror</option>"
				+ "<option value='10'>Suspense</option>"
				+ "<option value='11'>Com�dia</option>"
				+ "<option value='12'>Document�rio</option>"
				+ "<option value='13'>Biografia</option>"
				+ "<option value='14'>Anime</option></select></td>");
		out.println("<INPUT TYPE='SUBMIT' VALUE='Incluir'>");
		out.println("</FORM></BODY></HTML>");
	}
		}

