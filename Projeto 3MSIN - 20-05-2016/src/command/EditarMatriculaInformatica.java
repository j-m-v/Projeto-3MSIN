package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MatriculaInformatica;

public class EditarMatriculaInformatica implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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


		MatriculaInformatica m = new MatriculaInformatica();
		String data = m.dataAtual();
		MatriculaInformatica MatriculaInformatica = new MatriculaInformatica(idMatricula, data, valor, pStatusMatricula,
				pStatusPagamento, idAluno, idCurso);
		RequestDispatcher view = null;

		MatriculaInformatica.consultar();
		request.setAttribute("cliente", MatriculaInformatica.getTO());
		view = request.getRequestDispatcher("AlterarMatriculaInformatica.jsp");

		view.forward(request, response);

	}
}
