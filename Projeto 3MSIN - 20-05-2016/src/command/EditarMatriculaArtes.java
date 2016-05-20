package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MatriculaArtes;

public class EditarMatriculaArtes implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pIdMatricula = request.getParameter("idMatricula");
		String pIdAluno = request.getParameter("idAluno");
		String pIdCurso = request.getParameter("idCurso");
		double valor = Double.parseDouble(request.getParameter("valor") != null ? request.getParameter("valor") : "0");
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
		MatriculaArtes matriculaArtes = new MatriculaArtes(idMatricula, data, valor, pStatusMatricula, pStatusPagamento,
				idAluno, idCurso);
		RequestDispatcher view = null;

		matriculaArtes.consultar();
		request.setAttribute("matriculaArtes", matriculaArtes.getTO());
		view = request.getRequestDispatcher("AlterarMatriculaArtes.jsp");

		view.forward(request, response);
	}
}
