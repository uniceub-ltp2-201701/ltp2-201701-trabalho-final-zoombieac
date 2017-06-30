package control;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperar os parametros
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String mensagem = null;
		
		try {
			//Referenciar o driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			
			//Criar as strings de conexao
			String url = "jdbc:mysql://localhost/IMDb";
			String username = "root"; //nome do usuario no BD
			String password = ""; //senha do usuario no BD
			
			//Realizar a conexao ao BD
			Connection conexao = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = conexao.prepareStatement("select idlogin from login where usuario = ? and senha = ?");
			ps.setString(1, usuario);
			ps.setString(2, senha);
			
			//Executando a query e recebendo o ResultSet
			ResultSet rs = ps.executeQuery();

			//Verificar se o ResultSet tem resultado
			if (rs.first()) {
				mensagem = "<a href='/IMDb/index.html'>Início(index)</a><br><body><h2>Links de navegação</h2>"

+ "<a href='/IMDb/gerenciarFilmes'>Gerenciar Filmes</a><br>"

+ "<a href='/IMDb/gerenciarGeneros'>Gerenciar Gêneros</a><br>"

+ "<a href='/IMDb/gerenciarAtores'>Gerenciar Atores</a></body></html><br>"

+ "<a href='/IMDb/gerenciarDiretores'>Gerenciar Diretores</a><br><br><br>"

+ "<a href='/IMDb/index.html'>LOGOUT</a></body></html>";
				
			} else {
				mensagem = "<body><h1>Usuário ou senha inválido(a)</h1></body></html><br><br><br>"
						+ "<a href='/IMDb/index.html'>Voltar</a></body></html>";
			}
			
			//Fechar o ResultSet
			rs.close();
			//Fechar o PreparedStatement
			ps.close();
			//Fechar o Connnection
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		//Retornar HTML para o cliente
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Resultado do Login</title></head>");
		out.println(mensagem);
	}

}
