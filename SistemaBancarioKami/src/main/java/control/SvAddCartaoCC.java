package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cartao;
import model.Corrente;

@WebServlet("/SvAddCartaoCC")
public class SvAddCartaoCC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));

		Corrente c = new Corrente();

		if (c.localizar(id) != null) {
			String nomeCartao = request.getParameter("nomeCartao");
			String numeroCartao = request.getParameter("numeroCartao");
			String codigoCartao = request.getParameter("codigoCartao");
			String bandeiraCartao = request.getParameter("bandeiraCartao");
			double limiteCartao = Double.parseDouble(request.getParameter("limiteCartao"));

			Cartao ct = new Cartao();

			ct.setNome(nomeCartao);
			ct.setNumero(numeroCartao);
			ct.setCodigo(codigoCartao);
			ct.setBandeira(bandeiraCartao);
			ct.setLimite(limiteCartao);

			if (c.getListaCartao() == null) {
				c.setListaCartao(new ArrayList<>());
			}

			c.getListaCartao().add(ct);

			if (ct.salvar()) {
				if (c.atualizarCorrente()) {
					request.setAttribute("msg", "Dados atualizados e cartão cadastrado com sucesso!");
				} else {
					request.setAttribute("msg", "Cartão cadastrado, mas houve um problema na atualização da corrente.");
				}
			} else {
				request.setAttribute("msg", "Cartão não cadastrado!");
			}
		} else {
			request.setAttribute("msg", "Conta corrente não encontrada!");
		}

		request.getRequestDispatcher("correnteAddCartao.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
