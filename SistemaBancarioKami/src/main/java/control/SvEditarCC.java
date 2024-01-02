package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corrente;

@WebServlet("/SvEditarCC")
public class SvEditarCC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String editar = request.getParameter("editar");
		String novoValor = request.getParameter("novoValor");
		long id = Long.parseLong(request.getParameter("id"));
		
		if (id < 0 || editar.isEmpty() || novoValor.isEmpty()) {
            request.setAttribute("msg", "ID, Atributo ou Novo Valor não informado");
        } else {
            Corrente c = new Corrente();
            if (c.editar(id, editar, novoValor)) {
                request.setAttribute("msg", c.getMsg());
            } else {
                request.setAttribute("msg", c.getMsg());
            }
        }
		request.getRequestDispatcher("correnteEditar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
