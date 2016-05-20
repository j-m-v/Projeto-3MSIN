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

public class CriarCursoInformatica implements Command {

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
		String pLivros = request.getParameter("livros");
		String pDescricaoMaterial = request.getParameter("descricaoMaterial");

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

		CursoInformatica CursoInformatica = new CursoInformatica(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto, vagas, valor,
				pLivros, pDescricaoMaterial);
		HttpSession session = request.getSession();

		
			CursoInformatica.incluir();
			ArrayList<CursoInformaticaTO> lista = new ArrayList<>();
			lista.add(CursoInformatica.getTO());	
			request.setAttribute("lista", lista);
			RequestDispatcher view = request.getRequestDispatcher("ListarCursoInformatica.jsp");
			view.forward(request, response);
			
	}
}
