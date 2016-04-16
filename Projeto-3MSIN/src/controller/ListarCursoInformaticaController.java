package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.ListarCursoInformatica;
import to.CursoInformaticaTO;

/**
 * Servlet implementation class ListarClientesController
 * @param <RequestDispatcher>
 */
@WebServlet("/listar_clientes.do")
public class ListarCursoInformaticaController<RequestDispatcher> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String chave = request.getParameter("data[search]");
			ListarCursoInformatica cursoInformatica = new ListarCursoInformatica();
			ArrayList<CursoInformaticaTO> lista;
			if(chave != null && chave.length() > 0){
				lista = cursoInformatica.listarCursos(chave);
			} else {
				lista = cursoInformatica.listarCursos();
			}
			request.setAttribute("lista", lista);
		javax.servlet.RequestDispatcher dispatcher = request.
				getRequestDispatcher("ListarAlunos.jsp");
		dispatcher.forward(request, response);
		}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
