package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MatriculaInformatica;
import to.MatriculaInformaticaTO;

	/**
	 * Servlet implementation class ManterClienteController
	 */
	@WebServlet("/ManterMatriculaInformatica.do")
	public class MatriculaInformaticaController extends HttpServlet {
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
			String pAcao = request.getParameter("acao");
			String pIdMatricula = request.getParameter("idMatricula");
			String pIdAluno= request.getParameter("idAluno");
			String pIdCurso= request.getParameter("idCurso");
			String pValorMatricula= request.getParameter("valorMatricula");
			String pStatusMatricula= request.getParameter("statusMatricula");
			String pStatusPagamento= request.getParameter("statusPagamento");
			
			int idMatricula = 0;
			try {
				idMatricula = Integer.parseInt(pIdMatricula);
			} catch (NumberFormatException e) {}
			
			int idAluno = 0;
			try {
				idAluno = Integer.parseInt(pIdAluno);
			} catch (NumberFormatException e) {}
			
			int idCurso = 0;
			try {
				idCurso = Integer.parseInt(pIdCurso);
			} catch (NumberFormatException e) {}
			
			double valorMatricula = 0;
			try {
				valorMatricula = Double.parseDouble(pValorMatricula);
			} catch (NumberFormatException e) {}
			
			MatriculaInformatica matricula = new MatriculaInformatica();
			String data = matricula.dataAtual();
					
			MatriculaInformatica matriculaInformatica = new MatriculaInformatica(idMatricula, data, valorMatricula, pStatusMatricula, pStatusPagamento, idAluno, idCurso);

			if (pAcao.equals("Inserir")) {
				matriculaInformatica.incluir();
			} else if (pAcao.equals("Excluir")) {
				matriculaInformatica.deletar();
			} else if (pAcao.equals("Alterar")) {
				matriculaInformatica.alterar();
			} else if (pAcao.equals("Consultar")) {
				matriculaInformatica.consultar();
			}

			MatriculaInformaticaTO to = new MatriculaInformaticaTO();
			to.setCodigoMatricula(matriculaInformatica.getCodigoMatricula());
			to.setCodigoAluno(matriculaInformatica.getCodigoAluno());
			to.setCodigoCurso(matriculaInformatica.getCodigoCurso());
			to.setDataMatricula(matriculaInformatica.getDataMatricula());
			to.setValorMatricula(matriculaInformatica.getValorMatricula());
			to.setStatusMatricula(matriculaInformatica.getStatusMatricula());
			to.setStatusPagamento(matriculaInformatica.getStatusPagamento());

			request.setAttribute("matriculaInformatica", to);

			RequestDispatcher view = 
						request.getRequestDispatcher("MatriculaInformatica.jsp");
			view.forward(request, response);
		}

	

}
