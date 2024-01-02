package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Poupanca;

@WebServlet("/SvExibirSaldoCP")
public class SvExibirSaldoCP extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
long id = Long.parseLong(request.getParameter("id"));
		
		if (id < 0) {
			request.setAttribute("msg", "ID não informado");
		} else {
			Poupanca p = new Poupanca();

			if (p.exibirSaldo(id)) {
				request.setAttribute("msg", p.getMsg());
			} else {
				request.setAttribute("msg", p.getMsg());
			}
		}
		request.getRequestDispatcher("poupancaSaldo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
