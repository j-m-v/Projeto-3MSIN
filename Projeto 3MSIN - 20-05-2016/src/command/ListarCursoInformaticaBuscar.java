package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListarCursoInformaticaDAO;
import model.CursoInformatica;
import to.CursoInformaticaTO;

public class ListarCursoInformaticaBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String chave = request.getParameter("data[search]");
		ListarCursoInformaticaDAO informatica;
		ArrayList<CursoInformaticaTO> lista = null;
		HttpSession session = request.getSession();

		if(chave != null && chave.length() > 0){
			lista = informatica.listarCursos(chave);
		}else{	
			lista = informatica.listarCursos();
		}
		session.setAttribute("lista", lista);
		
		
		
		javax.servlet.RequestDispatcher dispatcher = request.
				getRequestDispatcher("ListarCursoInformatica.jsp");
		dispatcher.forward(request, response);
	}
}
