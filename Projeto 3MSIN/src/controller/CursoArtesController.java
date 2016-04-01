package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CursoArtes;
import to.CursoArtesTO;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCursoArtes.do")
public class CursoArtesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pCodigo = request.getParameter("id");
		String pAcao = request.getParameter("acao");
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorarioPrevisto = request.getParameter("horarioPrevisto");
		String pVagas = request.getParameter("vagas");
		String pValor = request.getParameter("valor");
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

		double valor = 0;
		try {
			valor = Double.parseDouble(pValor);
		} catch (NumberFormatException e) {
		}

		CursoArtes cursoArtes = new CursoArtes(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto, vagas, valor,
				pLivros, pDescricaoMaterial);

		if (pAcao.equals("Inserir")) {
			cursoArtes.incluir();
		} else if (pAcao.equals("Excluir")) {
			cursoArtes.deletar();
		} else if (pAcao.equals("Alterar")) {
			cursoArtes.alterar();
		} else if (pAcao.equals("Consultar")) {
			cursoArtes.consultar();
		}
		cursoArtes.consultar();

		CursoArtesTO to = new CursoArtesTO();
		to.setCodigoArtes(cursoArtes.getCodigoArtes());
		to.setNomeArtes(cursoArtes.getNomeArtes());
		to.setLivros(cursoArtes.getLivros());
		to.setDataInicio(cursoArtes.getDataInicio());
		to.setDataTermino(cursoArtes.getDataTermino());
		to.setHorarioPrevisto(cursoArtes.getHorarioPrevisto());
		to.setNumeroVagas(cursoArtes.getNumeroVagas());
		to.setValorCurso(cursoArtes.getValorCurso());
		to.setDescricaoMaterial(cursoArtes.getDescricaoMaterial());

		request.setAttribute("cursoArtes", to);

		RequestDispatcher view = request.getRequestDispatcher("CursoArtes.jsp");
		view.forward(request, response);
	}

}