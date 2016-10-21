package br.com.matrix.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.matrix.aplicacao.ParametroEntrada;
import br.com.matrix.matrix.GerenciadorMatrix;
import br.com.matrix.matrix.SugestaoMatrix;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "Sugere", urlPatterns = {"/Sugere", "/sugere"})
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

		List<SugestaoMatrix> l = new ArrayList<>();

		GerenciadorMatrix g = new GerenciadorMatrix();

		ParametroEntrada par = new ParametroEntrada(request.getParameter("digit"));
		
		l.addAll(g.getLSugest(par));

		StringBuilder sb = new StringBuilder();

		for (SugestaoMatrix s : l) {
			sb.append(s.get());
		}

		response.getWriter().append(sb.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
