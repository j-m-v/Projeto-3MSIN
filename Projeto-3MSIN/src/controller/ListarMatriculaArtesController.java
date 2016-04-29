package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListaMatriculaArtes;
import to.ListaMatriculaArtesTO;

/**
 * Servlet implementation class ListarMatriculaArtesController
 */
@WebServlet("/Listar_MatriculaArtes.do")
public class ListarMatriculaArtesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String chave = request.getParameter("data[search]");
		ListaMatriculaArtes artes = new ListaMatriculaArtes();
		ListaMatriculaArtesTO lista;
		if (chave != null && chave.length() > 0) {
			lista = artes.listarMatriculaArtes(chave);
		} else {
			lista = artes.listarMatriculaArtes();
		}
		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarMatriculaArtes.jsp");
		dispatcher.forward(request, response);
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
