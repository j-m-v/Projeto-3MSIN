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

public class VisualizarCursoInformatica implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pCodigo = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorarioPrevisto = request.getParameter("horario");
		String pVagas = request.getParameter("vagas");
		double valor = Double.parseDouble(request.getParameter("valor") != null ? request.getParameter("valor") : "0");
		String pSoftwares = request.getParameter("softwares");
		String pLaboratorios = request.getParameter("numeroLaboratorio");

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

		CursoInformatica informatica = new CursoInformatica(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto,
				vagas, valor, pSoftwares, pLaboratorios);
		RequestDispatcher view = null;
		
		
			informatica.consultar();
			request.setAttribute("informatica", informatica.getTO());
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
