package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corrente;
import model.Usuario;

@WebServlet("/SvCadastrarCC")
public class SvCadastrarCC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String agencia = request.getParameter("agencia");
		String nrConta = request.getParameter("nrConta");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		double limite = Double.parseDouble(request.getParameter("limite"));

		Corrente c = new Corrente();
		c.setAgencia(agencia);
		c.setNrConta(nrConta);
		c.setSaldo(saldo);
		c.setLimite(limite);

		Usuario user = new Usuario();
		user.setNome(nome);
		user.setCpf(cpf);
		user.setEmail(email);

		c.setUser(user);

		if (c.salvar()) {
			request.setAttribute("msg", "Conta corrente e usuário cadastrados com sucesso!");
		} else {
			request.setAttribute("msg", c.getMsg());
		}
		request.getRequestDispatcher("correnteCadastrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
