package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CursoInformatica;
import to.CursoInformaticaTO;

public class AlterarCursoInformatica implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pCodigo = request.getParameter("id");
    	String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorarioPrevisto = request.getParameter("horarioPrevisto");
		String pVagas = request.getParameter("vagas");
		double valor = Double.parseDouble(request.getParameter("valor") != null ? request.getParameter("valor") : "0");
		String pSoftwares = request.getParameter("softwares");
		String pLaboratorios = request.getParameter("numeroLaboratorios");

		int codigo = 0;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (NumberFormatException e) {
		}

		int vagas = 0;
		try {
			vagas = Integer.parseInt(pVagas);
		} catch (NumberFormatException e) {
		}

		CursoInformatica cursoInformatica = new CursoInformatica(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto,
				vagas, valor, pSoftwares, pLaboratorios);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		    cursoInformatica.alterar();
			@SuppressWarnings("unchecked")
			ArrayList<CursoInformaticaTO> lista = (ArrayList<CursoInformaticaTO>) session.getAttribute("lista");
			int pos = busca(cursoInformatica, lista);
			lista.remove(pos);
			lista.add(pos, cursoInformatica.getTO());
			session.setAttribute("lista", lista);
			request.setAttribute("informatica", cursoInformatica.getTO());
			view = request.getRequestDispatcher("ConsultarCursoInformatica.jsp");
			view.forward(request, response);
			
		
	}
		public int busca(CursoInformatica cursoInformatica, ArrayList<CursoInformaticaTO> lista) {
			CursoInformaticaTO to;
			for (int i = 0; i < lista.size(); i++) {
				to = lista.get(i);
				if (to.getId() == cursoInformatica.getId()) {
					return i;
				}
			}
			return -1;
		}

}
