package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CursoArtes;
import to.CursoArtesTO;

public class ExcluirCursoArtes implements Command {

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

		CursoArtes cursoArtes = new CursoArtes(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto, vagas, valor,
				pLivros, pDescricaoMaterial);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		
			cursoArtes.deletar();
			@SuppressWarnings("unchecked")
			ArrayList<CursoArtesTO> lista = (ArrayList<CursoArtesTO>) session.getAttribute("lista");
			lista.remove(busca(cursoArtes, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarClientes.jsp");
			view.forward(request, response);
		
}
		public int busca(CursoArtes cursoArtes, ArrayList<CursoArtesTO> lista) {
			CursoArtesTO to;
			for (int i = 0; i < lista.size(); i++) {
				to = lista.get(i);
				if (to.getId() == cursoArtes.getId()) {
					return i;
				}
			}
			return -1;
		}

}
