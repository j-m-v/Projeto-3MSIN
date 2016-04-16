package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListarMatriculaInformatica;
import to.MatriculaInformaticaTO;

/**
 * Servlet implementation class ListarMatriculaInformaticaController
 */
@WebServlet("/Listar_MatriculaInformatica.do")
public class ListarMatriculaInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String key = request.getParameter("data[search]");
			int chave = 0;
			try {
				chave = Integer.parseInt(key);
			} catch (NumberFormatException e) {}
			
			ListarMatriculaInformatica Informatica = new ListarMatriculaInformatica();
			ArrayList<MatriculaInformaticaTO> lista;
			if(chave>0){
				lista = Informatica.listarMatriculaInformatica(chave);
			} else {
				lista = Informatica.listarMatriculaInformatica();
			}
			request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.
				getRequestDispatcher("Listar_MatriculaInformatica.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
