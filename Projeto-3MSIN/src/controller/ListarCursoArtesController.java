package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListarCursoArtes;
import to.CursoArtesTO;

/**
 * Servlet implementation class ListarClientesController
 * @param <RequestDispatcher>
 */
@WebServlet("/Listar_CursoArtes.do")
public class ListarCursoArtesController<RequestDispatcher> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String chave = request.getParameter("data[search]");
			ListarCursoArtes cursoArtes = new ListarCursoArtes();
			ArrayList<CursoArtesTO> lista;
			if(chave != null && chave.length() > 0){
				lista = cursoArtes.listarCursos(chave);
			} else {
				lista = cursoArtes.listarCursos();
			}
			request.setAttribute("lista", lista);
		javax.servlet.RequestDispatcher dispatcher = request.
				getRequestDispatcher("ListarCursoArtes.jsp");
		dispatcher.forward(request, response);
		}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
