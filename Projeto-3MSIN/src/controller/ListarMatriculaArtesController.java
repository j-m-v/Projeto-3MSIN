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

import model.ListarMatriculaArtes;
import to.MatriculaArtesTO;

/**
 * Servlet implementation class ListarMatriculaArtesController
 */
@WebServlet("/Listar_MatriculaArtes.do")
public class ListarMatriculaArtesController extends HttpServlet {
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
			
			ListarMatriculaArtes artes = new ListarMatriculaArtes();
			ArrayList<MatriculaArtesTO> lista;
			if(chave>0){
				lista = artes.listarMatriculaArtes(chave);
			} else {
				lista = artes.listarMatriculaArtes();
			}
			request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.
				getRequestDispatcher("Listar_MatriculaArtes.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
