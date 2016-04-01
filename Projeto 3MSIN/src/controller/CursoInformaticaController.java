package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CursoInformatica;
import to.CursoInformaticaTO;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterCursoInformatica.do")
public class CursoInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pCodigo = request.getParameter("id");
		String pAcao = request.getParameter("acao");
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHorarioPrevisto = request.getParameter("horarioPrevisto");
		String pVagas = request.getParameter("vagas");
		String pValor = request.getParameter("valor");
		String pSoftwares = request.getParameter("softwares");
		String pLaboratorios = request.getParameter("numeroLaboratorios");
		
		int codigo = 0;
		try {
			codigo = Integer.parseInt(pCodigo);
		} catch (NumberFormatException e) {}
		
		int vagas = 0;	
		try {
			vagas = Integer.parseInt(pVagas);
		} catch (NumberFormatException e) {}
		
		double valor = 0;
		try{
		valor = Double.parseDouble(pValor);
		} catch (NumberFormatException e) {}
	
		CursoInformatica cursoInformatica = new CursoInformatica(codigo, pNome, pDataInicio, pDataTermino, pHorarioPrevisto,
		vagas, valor, pSoftwares, pLaboratorios);

		if (pAcao.equals("Inserir")) {
			cursoInformatica.incluir();
		} else if (pAcao.equals("Excluir")) {
			cursoInformatica.deletar();
		} else if (pAcao.equals("Alterar")) {
			cursoInformatica.alterar();
		} else if (pAcao.equals("Consultar")) {
			cursoInformatica.consultar();
		}
		cursoInformatica.consultar();

		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setCodigoInformatica(cursoInformatica.getCodigoInformatica());
		to.setNome(cursoInformatica.getNome());
		to.setSoftwares(cursoInformatica.getSoftwares());
		to.setDataInicio(cursoInformatica.getDataInicio());
		to.setDataTermino(cursoInformatica.getDataTermino());
		to.setHorarioPrevisto(cursoInformatica.getHorarioPrevisto());
		to.setNumeroVagas(cursoInformatica.getNumeroVagas());
		to.setValorCurso(cursoInformatica.getValorCurso());
		to.setNumeroLaboratorios(cursoInformatica.getNumeroLaboratorios());

		request.setAttribute("cursoInformatica", to);

		RequestDispatcher view = 
					request.getRequestDispatcher("CursoInformatica.jsp");
		view.forward(request, response);
	}

}