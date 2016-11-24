package br.com.matrix.web;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.com.matrix.aplicacao.ParametroEntrada;
import br.com.matrix.banco.Database;
import br.com.matrix.banco.tabelas.Pontuacoes;
import br.com.matrix.banco.tabelas.interfaces.ICampo;
import br.com.matrix.banco.tabelas.interfaces.ILinha;
import br.com.matrix.matrix.GerenciadorMatrix;
import br.com.matrix.matrix.SugestaoMatrix;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "Sugere", urlPatterns = { "/Sugere", "/sugere" })
public class Sugere extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sugere() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("digit") != null && request.getParameter("digit") != "") {

			List<SugestaoMatrix> l = new ArrayList<>();

			ParametroEntrada par = new ParametroEntrada(request.getParameter("digit"));

			GerenciadorMatrix g = GerenciadorMatrix.getInstance();

			l.addAll(g.getLSugest(par));

			StringBuilder sb = new StringBuilder();


			
			l.forEach(x -> sb.append(x.get()+","));
			
			response.getWriter().write(sb.toString());
			

			updateText(request.getSession(), par);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void updateText(HttpSession session, ParametroEntrada digit) {
		if (Database.getSessionId() == 0)
			Database.setSessionId(session.getId().hashCode());
		Database.update(digit);

		// List<String> pontuacao = new ArrayList<>();
		// List<ILinha> temp = Database
		// .execute(Database.selectBuilder(Pontuacoes.get().getColunas()) + "
		// where ds not like '% %' ");
		//
		// for (ILinha t : temp) {
		// for (ICampo c : t.getCampos()) {
		// if (c.getColuna().getNm().equalsIgnoreCase("ds"))
		// pontuacao.add(c.getValor().toString());
		// }
		// }

		// StringBuilder regex = new StringBuilder("(?<=");
		//
		// for (String p : pontuacao) {
		// if (p.equals("")) {
		// pontuacao.remove(p);
		// continue;
		// }
		// if (!(pontuacao.indexOf(p) == 1))
		// regex.append("|");
		//
		// regex.append(p);
		// }
		//
		// regex.append(")");

		System.out.println(digit.getAll());
	}

}
