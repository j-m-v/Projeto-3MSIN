package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListaMatriculaInformatica;
import to.ListaMatriculaInformaticaTO;

/**
 * Servlet implementation class ListarmatriculaInformaticaController
 */
@WebServlet("/Listar_matriculaInformatica.do")
public class ListarMatriculaInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String chave = request.getParameter("data[search]");
		ListaMatriculaInformatica info = new ListaMatriculaInformatica();
		ListaMatriculaInformaticaTO lista;
		if (chave != null && chave.length() > 0) {
			lista = info.listarMatriculaInformatica(chave);
		} else {
			lista = info.listarMatriculaInformatica();
		}
		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarMatriculaInformatica.jsp");
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
