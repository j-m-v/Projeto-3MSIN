package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MatriculaInformatica;
import to.MatriculaInformaticaTO;
import java.util.ArrayList;

@WebServlet("/ManterMatriculaInformatica.do")
public class ManterMatriculaInformaticaController extends HttpServlet {
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
		String pAcao = request.getParameter("acao");
		String pIdMatricula = request.getParameter("idMatricula");
		String pIdAluno = request.getParameter("idAluno");
		String pIdCurso = request.getParameter("idCurso");
		double valorMatricula = Double.parseDouble(request.getParameter("valor") != null ? request.getParameter("valor") : "0");
		String pValorMatricula = request.getParameter("valor");
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

		MatriculaInformatica m = new MatriculaInformatica();
		String data = m.dataAtual();
		MatriculaInformatica matriculaInformatica = new MatriculaInformatica(idMatricula, data, valorMatricula, pStatusMatricula,
				pStatusPagamento, idAluno, idCurso);
		RequestDispatcher view = null;

		if (pAcao.equals("Criar")) {
			matriculaInformatica.incluir();
			ArrayList<MatriculaInformaticaTO> lista = new ArrayList<>();
			lista.add(matriculaInformatica.getTO());
			request.setAttribute("lista", lista);
			view = request.getRequestDispatcher("Listar_MatriculaInformatica.jsp");
		} else if (pAcao.equals("Excluir")) {
			matriculaInformatica.deletar();
			view = request.getRequestDispatcher("Listar_MatriculaInformatica.html");
		} else if (pAcao.equals("Alterar")) {
			matriculaInformatica.alterar();
			request.setAttribute("matriculaInformatica", matriculaInformatica.getTO());
			view = request.getRequestDispatcher("Consultar_MatriculaInformatica.jsp");
		} else if (pAcao.equals("Visualizar")) {
			matriculaInformatica.consultar();
			request.setAttribute("matriculaInformatica", matriculaInformatica.getTO());
			view = request.getRequestDispatcher("Consultar_MatriculaInformatica.jsp");
		} else if (pAcao.equals("Editar")) {
			matriculaInformatica.consultar();
			request.setAttribute("matriculaInformatica", matriculaInformatica.getTO());
			view = request.getRequestDispatcher("Alterar_MatriculaInformatica.jsp");
		}
		view.forward(request, response);
	}

}
