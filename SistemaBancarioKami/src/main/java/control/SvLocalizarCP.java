package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Poupanca;

@WebServlet("/SvLocalizarCP")
public class SvLocalizarCP extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));

			if (id < 0) {
				request.setAttribute("msg", "ID não informado");
			} else {
				Poupanca p = new Poupanca();

				if (p.localizar(id)!=null) {
					request.setAttribute("msg", p.getMsg());
				} else {
					request.setAttribute("msg", p.getMsg());
				}
			}
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "ID inválido");
		}
		request.getRequestDispatcher("poupancaLocalizar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
