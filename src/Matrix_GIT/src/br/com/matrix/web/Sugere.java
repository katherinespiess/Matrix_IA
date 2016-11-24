package br.com.matrix.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.matrix.aplicacao.ParametroEntrada;
import br.com.matrix.banco.Database;
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

			ParametroEntrada par = new ParametroEntrada(request.getParameter("digit"));

			GerenciadorMatrix g = GerenciadorMatrix.getInstance();

			List<SugestaoMatrix> l = g.getLSugest(par);
			if (l.size() < 1){
				g = GerenciadorMatrix.getNewInstance();
				l = g.getLSugest(par);
			}
				
			StringBuilder sb = new StringBuilder(l.size()*5);			
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
		
		System.out.println(digit.getAll());
	}

}
