package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CursoInformatica;
import to.CursoInformaticaTO;
import to.ListaCursoInformaticaTO;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCursoInformatica.do")
public class ManterCursoInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pCodigo = request.getParameter("id");
		String pAcao = request.getParameter("acao");
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorarioPrevisto = request.getParameter("horarioPrevisto");
		String pVagas = request.getParameter("vagas");
		double valor = Double.parseDouble(request.getParameter("valor") != null ? request.getParameter("valor") : "0");
		String pSoftwares = request.getParameter("softwares");
		String pLaboratorios = request.getParameter("numeroLaboratorios");

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

		CursoInformatica cursoInformatica = new CursoInformatica(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto,
				vagas, valor, pSoftwares, pLaboratorios);
		RequestDispatcher view = null;

		if (pAcao.equals("Criar")) {
			cursoInformatica.incluir();
			ArrayList<CursoInformaticaTO> lista = new ArrayList<>();
			lista.add(cursoInformatica.getTO());
			ListaCursoInformaticaTO inf = new ListaCursoInformaticaTO();
			request.setAttribute("lista", inf);
			view = request.getRequestDispatcher("ListarCursosInformatica.jsp");
		} else if (pAcao.equals("Excluir")) {
			cursoInformatica.deletar();
			view = request.getRequestDispatcher("ListarCursoInformatica.jsp");
		} else if (pAcao.equals("Alterar")) {
			cursoInformatica.alterar();
			request.setAttribute("informatica", cursoInformatica.getTO());
			view = request.getRequestDispatcher("ConsultarCursoInformatica.jsp");
		} else if (pAcao.equals("Visualizar")) {
			cursoInformatica.consultar();
			request.setAttribute("informatica", cursoInformatica.getTO());
			view = request.getRequestDispatcher("ConsultarCursoInformatica.jsp");
		} else if (pAcao.equals("Editar")) {
			cursoInformatica.consultar();
			request.setAttribute("informatica", cursoInformatica.getTO());
			view = request.getRequestDispatcher("AlterarCursoInformatica.jsp");
		}
		view.forward(request, response);
	}
}
