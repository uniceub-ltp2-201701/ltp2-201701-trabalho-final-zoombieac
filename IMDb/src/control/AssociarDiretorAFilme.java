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
import dao.AssociarDiretorAFilmeDAO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletAssociarPessoaAFilme
 */
@WebServlet("/associarDiretorAFilme")
public class AssociarDiretorAFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssociarDiretorAFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filme_id_filme = request.getParameter("id_filme");
		String diretor_id_diretor = request.getParameter("id_diretor");
		//Obter uma conexao com o BD
		Connection conexao = new Conexao().getConexao();
		//Criar a DAO
		AssociarDiretorAFilmeDAO adafd = new AssociarDiretorAFilmeDAO(conexao);
	
		
		boolean adicionar =  adafd.AssociarDiretorAFilme(filme_id_filme, diretor_id_diretor);
		PrintWriter out = response.getWriter();
		out.println("<HTML><HEAD><TITLE>Adicionar diretor a filme</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<form action='/IMDb/gerenciarDiretores'><input type='submit' value='Veja a lista de diretores disponiveis'></form>");
		//_______________________________________________VERIFICAR SE A INCLUSAO FOI BEM SUCEDIDA___________________________________________________________________________
				//_______________________________________________PUXANDO O VALOR ALOCADO NA VARIAVEL "resultado" PRESENTE NA NOSSA CLASSE "IncluiDisciplinaDAO"_____________________
				if (adicionar) {
				
					out.println("<TABLE border='1'>" +
				                "<TR>" +
							    "<TD><CENTER><FONT size='6'>Diretor adicionado ao filme. </FONT></CENTER></TD>" +
				                "</TR>" +
							    "</TABLE>");
				} else {
					out.println("<TABLE  border='1'>" +
			                "<TR>" +
						    "<TD><CENTER>Erro ao adicionar.</FONT></CENTER></TD>" +
			                "</TR>" +
			                "<TR>" +
						    "<TD><CENTER>OS DADOS FORAM INSERIDOS INCORRETAMENTE... TENTE NOVAMENTE MAIS TARDE</FONT></CENTER></TD>" +
			                "</TR>" +
						    "</TABLE>");
				}
						
				out.println("</BODY></HTML>");
			}
	
	
	}
