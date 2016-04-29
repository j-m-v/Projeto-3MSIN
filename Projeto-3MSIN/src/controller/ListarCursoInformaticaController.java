package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListaCursoInformatica;
import to.ListaCursoInformaticaTO;

/**
 * Servlet implementation class ListarClientesController
 * @param <RequestDispatcher>
 */
@WebServlet("Listar_CursoInformatica.do")
public class ListarCursoInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet1(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String chave = request.getParameter("data[search]");
			ListaCursoInformatica informatica = new ListaCursoInformatica();
			ListaCursoInformaticaTO lista;
			if(chave != null && chave.length() > 0){
				lista = informatica.listarCursoInformatica(chave);
			}else{	
				lista = informatica.listarCursoInformatica();
			}
			request.setAttribute("lista", lista);
		javax.servlet.RequestDispatcher dispatcher = request.
				getRequestDispatcher("ListarCursoInformatica.jsp");
		dispatcher.forward(request, response);
		}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
