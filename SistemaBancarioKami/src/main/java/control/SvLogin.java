package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SvLogin")
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		if (login.isEmpty() || senha.isEmpty()) {
			request.setAttribute("msg", "Login ou senha está em branco");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			if (login.equals("admin") && senha.equals("admin")) {
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Usuário inválido");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
