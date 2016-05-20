package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MatriculaInformatica;
import to.MatriculaInformaticaTO;

public class VisualizarMatriculaInformatica implements Command {

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
		view = request.getRequestDispatcher("ConsultarMatriculaInformatica.jsp");
		view.forward(request, response);
	}

	public int busca(MatriculaInformatica MatriculaInformatica, ArrayList<MatriculaInformaticaTO> lista) {
		MatriculaInformaticaTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == MatriculaInformatica.getId()) {
				return i;
			}
		}
		return -1;
	}

}
