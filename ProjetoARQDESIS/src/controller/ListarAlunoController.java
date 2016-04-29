package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ListaAluno;
import to.ListaAlunoTO;

/**
 * Servlet implementation class ListarClientesController
 */
@WebServlet("/Listar_Alunos.do")
public class ListarAlunoController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
			String chave = request.getParameter("data[search]");
			ListaAluno aluno = new ListaAluno();
			ListaAlunoTO lista;
			if(chave != null && chave.length() > 0){
				lista = aluno.listarAlunos(chave);
			} else {
				lista = aluno.listarAlunos();
			}
			request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.
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
