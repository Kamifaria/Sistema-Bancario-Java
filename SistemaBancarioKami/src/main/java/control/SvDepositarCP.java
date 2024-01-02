package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Poupanca;

@WebServlet("/SvDepositarCP")
public class SvDepositarCP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double valorDeposito = Double.parseDouble(request.getParameter("valorDeposito"));
		long id = Long.parseLong(request.getParameter("id"));
		
		if (id < 0 || valorDeposito <= 0) {
			request.setAttribute("msg", "ID ou Valor Deposito não informado");
		} else {
			Poupanca p = new Poupanca();

			if (p.depositar(id, valorDeposito)) {
				request.setAttribute("msg", p.getMsg());
			} else {
				request.setAttribute("msg", p.getMsg());
			}
		}
		request.getRequestDispatcher("poupancaDepositar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
