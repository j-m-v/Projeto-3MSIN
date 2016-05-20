package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MatriculaArtes;
import to.MatriculaArtesTO;

public class ExcluirMatriculaArtes implements Command {

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

		MatriculaArtes m = new MatriculaArtes();
		String data = m.dataAtual();
		MatriculaArtes matriculaArtes = new MatriculaArtes(idMatricula, data, valor, pStatusMatricula,
				pStatusPagamento, idAluno, idCurso);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		matriculaArtes.deletar();
		@SuppressWarnings("unchecked")
		ArrayList<MatriculaArtesTO> lista = (ArrayList<MatriculaArtesTO>) session
				.getAttribute("lista");
		lista.remove(busca(matriculaArtes, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarMatriculaArtes.jsp");
		view.forward(request, response);
	}

	public int busca(MatriculaArtes matriculaArtes, ArrayList<MatriculaArtesTO> lista) {
		MatriculaArtesTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == matriculaArtes.getId()) {
				return i;
			}
		}
		return -1;
	}

}
