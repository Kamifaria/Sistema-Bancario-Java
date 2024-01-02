package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corrente;

@WebServlet("/SvSacarCC")
public class SvSacarCC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double valorSaque = Double.parseDouble(request.getParameter("valorSaque"));
		long id = Long.parseLong(request.getParameter("id"));
		
		if (id < 0 || valorSaque <= 0) {
			request.setAttribute("msg", "ID ou Valor Saque não informado");
		} else {
			Corrente c = new Corrente();

			if (c.sacar(id, valorSaque)) {
				request.setAttribute("msg", c.getMsg());
			} else {
				request.setAttribute("msg", c.getMsg());
			}
		}
		request.getRequestDispatcher("correnteSacar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
