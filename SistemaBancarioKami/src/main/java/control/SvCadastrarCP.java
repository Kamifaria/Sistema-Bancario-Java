package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Poupanca;
import model.Usuario;

@WebServlet("/SvCadastrarCP")
public class SvCadastrarCP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agencia = request.getParameter("agencia");
		String nrConta = request.getParameter("nrConta");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		double rendimento = Double.parseDouble(request.getParameter("rendimento"));
		
		Poupanca p = new Poupanca();
		p.setAgencia(agencia);
		p.setNrConta(nrConta);
		p.setSaldo(saldo);
		p.setRendimento(rendimento);

		Usuario user = new Usuario();
		user.setNome(nome);
		user.setCpf(cpf);
		user.setEmail(email);

		p.setUser(user);
		
		if (p.salvar()) {
			request.setAttribute("msg", "Conta poupança e usuário cadastrados com sucesso!");
		} else {
			request.setAttribute("msg", p.getMsg());
		}
		request.getRequestDispatcher("poupancaCadastrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
