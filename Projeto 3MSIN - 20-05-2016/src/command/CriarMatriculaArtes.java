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

public class CriarMatriculaArtes implements Command {

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
		HttpSession session = request.getSession();

		matriculaArtes.incluir();
		ArrayList<MatriculaArtesTO> lista = new ArrayList<>();
		lista.add(matriculaArtes.getTO());
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("ListarMatriculaArtes.jsp");
		view.forward(request, response);
	}
}
