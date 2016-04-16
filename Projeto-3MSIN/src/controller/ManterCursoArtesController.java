package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.CursoArtes;
import to.CursoArtesTO;


@WebServlet("/ManterCursoArtes.do")
public class ManterCursoArtesController extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pCodigo = request.getParameter("id");
		String pAcao = request.getParameter("acao");
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorarioPrevisto = request.getParameter("horarioPrevisto");
		String pVagas = request.getParameter("vagas");
		double valor = Double.parseDouble(request.getParameter("valor") != null ? request.getParameter("valor") : "0");
		String pLivros = request.getParameter("livros");
		String pDescricaoMaterial = request.getParameter("descricaoMaterial");

		int codigo = 0;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (NumberFormatException e) {
		}

		int vagas = 0;
		try {
			vagas = Integer.parseInt(pVagas);
		} catch (NumberFormatException e) {
		}


		CursoArtes cursoArtes = new CursoArtes(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto, vagas, valor,
				pLivros, pDescricaoMaterial);
		RequestDispatcher view = null;
		
		  if (pAcao.equals("Criar")) {	
			cursoArtes.incluir();
			ArrayList<CursoArtesTO> lista = new ArrayList<>();
			lista.add(cursoArtes.getTO());
			request.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarCursoArtes.jsp");
		} else if (pAcao.equals("Excluir")) {
			cursoArtes.deletar();
			view = request.getRequestDispatcher("Listar_CursoArtes.html");			
		} else if (pAcao.equals("Alterar")) {
			cursoArtes.alterar();
			request.setAttribute("Curso", cursoArtes.getTO());
			view = request.getRequestDispatcher("VisualizarCursoArtes.jsp");			
		} else if (pAcao.equals("Visualizar")) {
			cursoArtes.consultar();
			request.setAttribute("Curso", cursoArtes.getTO());
			view = request.getRequestDispatcher("VisualizarCursoArtes.jsp");		
		} else if (pAcao.equals("Editar")) {
			cursoArtes.alterar();
			request.setAttribute("cliente", cursoArtes.getTO());
			view = request.getRequestDispatcher("AlterarCursoArtes.jsp");		
		}
		
		view.forward(request, response);

		

	}

}
