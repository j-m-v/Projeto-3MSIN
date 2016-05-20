package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListaMatriculaArtes;
import to.MatriculaArtesTO;

public class ListarMatriculaArtesBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String chave = request.getParameter("data[search]");
		ListaMatriculaArtes matricula = new ListaMatriculaArtes();
		ArrayList<MatriculaArtesTO> lista = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			lista = matricula.listarMatriculaArtes(chave);
		} else {
			lista = matricula.listarMatriculaArtes();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarMatriculaArtes.jsp");
		dispatcher.forward(request, response);
	}
}
