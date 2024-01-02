package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corrente;

@WebServlet("/SvExibirSaldoCC")
public class SvExibirSaldoCC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
long id = Long.parseLong(request.getParameter("id"));
		
		if (id < 0) {
			request.setAttribute("msg", "ID não informado");
		} else {
			Corrente c = new Corrente();

			if (c.exibirSaldo(id)) {
				request.setAttribute("msg", c.getMsg());
			} else {
				request.setAttribute("msg", c.getMsg());
			}
		}
		request.getRequestDispatcher("correnteSaldo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
