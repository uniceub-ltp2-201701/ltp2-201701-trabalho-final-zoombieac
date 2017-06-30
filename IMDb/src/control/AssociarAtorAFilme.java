package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.IncluirFilmeDAO;
import model.Filme;
import dao.AssociarAtorAFilmeDAO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletAssociarPessoaAFilme
 */
@WebServlet("/associarAtorAFilme")
public class AssociarAtorAFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssociarAtorAFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filme_id_filme = request.getParameter("id_filme");
		String ator_id_ator = request.getParameter("id_ator");
		String personagem = request.getParameter("personagem");
		String papel = request.getParameter("papel");
		//Obter uma conexao com o BD
		Connection conexao = new Conexao().getConexao();
		//Criar a DAO
		AssociarAtorAFilmeDAO aaafd = new AssociarAtorAFilmeDAO(conexao);
		//
		//
		//ArrayList<Filme> AssociarAtorAoFilme = aaafd.getAdicionarAtorAoFilme(filme_id_filme);
		//request.setAttribute("associarAtorAoFilme", AssociarAtorAoFilme);
		//Inclui o contato
		boolean adicionar =  aaafd.AssociarPessoaAFilme(filme_id_filme, ator_id_ator, personagem, papel);
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Adicionar pessoa a filme</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<form action='/IMDb/gerenciarAtores'><input type='submit' value='Veja a lista de pessoas disponiveis'></form>");
		//_______________________________________________VERIFICAR SE A INCLUSAO FOI BEM SUCEDIDA___________________________________________________________________________
				//_______________________________________________PUXANDO O VALOR ALOCADO NA VARIAVEL "resultado" PRESENTE NA NOSSA CLASSE "IncluiDisciplinaDAO"_____________________
				if (adicionar) {
				
					out.println("<TABLE border='1'>" +
				                "<TR>" +
							    "<TD><CENTER><FONT size='6'>Ator adicionado.</FONT></CENTER><br><a href='/IMDb/gerenciarFilmes'>Voltar</a></TD>" +
				                "</TR>" +
							    "</TABLE>");
				} else {
					out.println("<TABLE  border='1'>" +
			                "<TR>" +
						    "<TD><CENTER>Erro.</FONT></CENTER></TD>" +
			                "</TR>" +
			                "<TR>" +
						    "<TD><CENTER>OS DADOS FORAM INSERIDOS INCORRETAMENTE... TENTE NOVAMENTE MAIS TARDE</FONT></CENTER></TD>" +
			                "</TR>" +
						    "</TABLE>");
				}
						
				out.println("</BODY></HTML>");
			}
	
	
	}