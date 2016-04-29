package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MatriculaArtes;
import to.ListaMatriculaArtesTO;
import to.MatriculaArtesTO;
import java.util.ArrayList;

@WebServlet("/ManterMatriculaArtes.do")
public class ManterMatriculaArtesController extends HttpServlet {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pIdMatricula = request.getParameter("idMatricula");
		String pIdAluno = request.getParameter("idAluno");
		String pIdCurso = request.getParameter("idCurso");
		double valor    = Double.parseDouble(request.getParameter("valor") != null ? request.getParameter("valor") : "0");
		String pStatusMatricula = request.getParameter("statusMatricula");
		String pStatusPagamento = request.getParameter("statusPagamento");

		int idMatricula = 0;
		try {
			idMatricula = Integer.parseInt(pIdMatricula);
		} catch (NumberFormatException e) {
		}
		
		int idAluno = 0;
		try {
			idAluno = Integer.parseInt(pIdAluno);
		} catch (NumberFormatException e) {
		}

		int idCurso = 0;
		try {
			idCurso = Integer.parseInt(pIdCurso);
		} catch (NumberFormatException e) {
		}

		MatriculaArtes m = new MatriculaArtes();
		String data = m.dataAtual();
		MatriculaArtes matriculaArtes = new MatriculaArtes(idMatricula, data, valor, pStatusMatricula,
				pStatusPagamento, idAluno, idCurso);
		RequestDispatcher view = null;

		if (pAcao.equals("Criar")) {
			matriculaArtes.incluir();
			ArrayList<MatriculaArtesTO> lista = new ArrayList<>();
			lista.add(matriculaArtes.getTO());
			ListaMatriculaArtesTO lma = new ListaMatriculaArtesTO();
			request.setAttribute("lista", lma);
			view = request.getRequestDispatcher("ListarMatriculaArtes.jsp");
		} else if (pAcao.equals("Excluir")) {
			matriculaArtes.deletar();
			view = request.getRequestDispatcher("ListarMatriculaArtes.jsp");
		} else if (pAcao.equals("Alterar")) {
			matriculaArtes.alterar();
			request.setAttribute("matriculaArtes", matriculaArtes.getTO());
			view = request.getRequestDispatcher("ConsultarMatriculaArtes.jsp");
		} else if (pAcao.equals("Visualizar")) {
			matriculaArtes.consultar();
			request.setAttribute("matriculaArtes", matriculaArtes.getTO());
			view = request.getRequestDispatcher("ConsultarMatriculaArtes.jsp");
		} else if (pAcao.equals("Editar")) {
			matriculaArtes.consultar();
			request.setAttribute("matriculaArtes", matriculaArtes.getTO());
			view = request.getRequestDispatcher("AlterarMatriculaArtes.jsp");
		}
		view.forward(request, response);
	}

}
