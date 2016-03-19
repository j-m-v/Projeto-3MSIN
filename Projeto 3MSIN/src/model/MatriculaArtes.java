package model;

import daos.MatriculaArtesDAO;
import to.MatriculaArtesTO;

public class MatriculaArtes {
	// atributos
	private int codigoMatricula;
	private int codigoAluno;
	private int codigoCurso;
	private String dataMatricula;
	private double valorMatricula;
	private String statusMatricula;
	private String statusPagamento;

	public MatriculaArtes() {
		codigoMatricula = 0;
		codigoAluno = 0;
		codigoCurso = 0;
		dataMatricula = "";
		valorMatricula = 0.0;
		statusMatricula = "";
		setStatusPagamento("");
	}

	public MatriculaArtes(String dataMatricula, double valorMatricula, String statusMatricula, String statusPagamento, int codigoAluno,
			int codigoCurso) {
		this.codigoAluno = codigoAluno;
		this.codigoCurso = codigoCurso;
		this.dataMatricula = dataMatricula;
		this.valorMatricula = valorMatricula;
		this.statusMatricula = statusMatricula;
		this.statusPagamento = statusPagamento;
	}

	public int getCodigoMatricula() {
		return codigoMatricula;
	}

	public int getCodigoAluno() {
		return codigoAluno;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public double getValorMatricula() {
		return valorMatricula;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public void setValorMatricula(double valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public void incluir() {
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		MatriculaArtesTO to = new MatriculaArtesTO();
		to.setCodigoAluno(codigoAluno);
		to.setCodigoCurso(codigoCurso);
		to.setDataMatricula(dataMatricula);
		to.setValorMatricula(valorMatricula);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.incluir(to);
	}

	public void alterar() {
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		MatriculaArtesTO to = new MatriculaArtesTO();
		to.setCodigoAluno(codigoAluno);
		to.setCodigoCurso(codigoCurso);
		to.setDataMatricula(dataMatricula);
		to.setValorMatricula(valorMatricula);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.alterar(to);
	}

	public void consultar() {
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		MatriculaArtesTO to = dao.consultar(codigoMatricula);
		codigoAluno = to.getCodigoAluno();
		codigoCurso = to.getCodigoCurso();
		dataMatricula = to.getDataMatricula();
		valorMatricula = to.getValorMatricula();
		statusMatricula = to.getStatusMatricula();
		statusPagamento = to.getStatusPagamento();
	}

	public void deletar() {
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		MatriculaArtesTO to = new MatriculaArtesTO();
		to.setCodigoMatricula(codigoMatricula);
		dao.deletar(to);
	}

	public void consultarTodos() {
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		dao.consultarTodos();
	}

	public void retornarUltimoID() {
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		dao.retornarUltimoID();
	}

}
