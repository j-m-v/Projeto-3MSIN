package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ListaMatriculaInformatica;
import to.MatriculaInformaticaTO;

public class ListarMatriculaInformaticaBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String chave = request.getParameter("data[search]");
		ListaMatriculaInformatica matricula = new ListaMatriculaInformatica();
		ArrayList<MatriculaInformaticaTO> lista = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			lista = matricula.listarMatriculaInformatica(chave);
		} else {
			lista = matricula.listarMatriculaInformatica();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarMatriculaInformatica.jsp");
		dispatcher.forward(request, response);
	}
}
