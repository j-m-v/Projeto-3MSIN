package model;


import dao.CursoInformaticaDAO;
import to.CursoInformaticaTO;

public class CursoInformatica {

	private int codigoInformatica;
	private String nomeInfo;
	private String dataInicio;
	private String dataTermino;
	private String horarioPrevisto;
	private int numeroVagas;
	private double valorCurso;
	private String softwares;
	private String numeroLaboratorios;

	public CursoInformatica() {

		codigoInformatica = 0;
		nomeInfo = "";
		dataInicio = "";
		dataTermino = "";
		horarioPrevisto = "";
		numeroVagas = 0;
		valorCurso = 0.0;
		softwares = "";
		numeroLaboratorios = "";

	}

	public CursoInformatica(String nome, String dataInicio, String dataTermino, String horarioPrevisto, int numeroVagas,
			double valorCurso, String softwares, String numeroLaboratorios) {
		this.nomeInfo = nome;
		this.softwares = softwares;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horarioPrevisto = horarioPrevisto;
		this.numeroVagas = numeroVagas;
		this.valorCurso = valorCurso;
		this.numeroLaboratorios = numeroLaboratorios;
	}
	
	public CursoInformatica(int codigo, String nome, String dataInicio, String dataTermino, String horarioPrevisto, int numeroVagas,
			double valorCurso, String softwares, String numeroLaboratorios) {
		this.codigoInformatica = codigo;
		this.nomeInfo = nome;
		this.softwares = softwares;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horarioPrevisto = horarioPrevisto;
		this.numeroVagas = numeroVagas;
		this.valorCurso = valorCurso;
		this.numeroLaboratorios = numeroLaboratorios;
	}
	
	

	// MÉTODOS DE ACESSO
	public int getCodigoInformatica() {
		return codigoInformatica;
	}

	public String getNome() {
		return nomeInfo;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public String getHorarioPrevisto() {
		return horarioPrevisto;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public double getValorCurso() {
		return valorCurso;
	}

	public String getSoftwares() {
		return softwares;
	}

	public String getNumeroLaboratorios() {
		return numeroLaboratorios;
	}

	// MÉTODOS MODIFICADORES
	public void setCodigoInformatica(int codigoInformatica) {
		this.codigoInformatica = codigoInformatica;
	}

	public void setNome(String nomeCurso) {
		this.nomeInfo = nomeCurso;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public void setHorarioPrevisto(String horarioPrevisto) {
		this.horarioPrevisto = horarioPrevisto;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}

	public void setSoftwares(String softwares) {
		this.softwares = softwares;
	}

	public void setNumeroLaboratorios(String numeroLaboratorios) {
		this.numeroLaboratorios = numeroLaboratorios;
	}

	public void incluir() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setNome(nomeInfo);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorios(numeroLaboratorios);
		dao.incluir(to);
		setCodigoInformatica(to.getCodigoInformatica());
	}
	
	public CursoInformaticaTO getTO() {
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setCodigoInformatica(codigoInformatica);
		to.setNome(nomeInfo);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorios(numeroLaboratorios);
		return to;
	}

	public void alterar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setCodigoInformatica(codigoInformatica);
		to.setNome(nomeInfo);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setSoftwares(softwares);
		to.setNumeroLaboratorios(numeroLaboratorios);
		dao.alterar(to);
	}

	public void consultar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = dao.consultar(codigoInformatica);
		nomeInfo = to.getNome();
		dataInicio = to.getDataInicio();
		dataTermino = to.getDataTermino();
		horarioPrevisto = to.getHorarioPrevisto();
		numeroVagas = to.getNumeroVagas();
		valorCurso = to.getValorCurso();
		softwares = to.getSoftwares();
		numeroLaboratorios = to.getNumeroLaboratorios();
	}

	public void deletar() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = new CursoInformaticaTO();
		to.setCodigoInformatica(codigoInformatica);
		dao.deletar(to);
	}

	public void consultarTodos() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		dao.consultarTodos();
	}

	public void retornarUltimoID() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		dao.retornarUltimoID();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoInformatica other = (CursoInformatica) obj;
		if (nomeInfo == null) {
			if (other.nomeInfo != null)
				return false;
		} else if (!nomeInfo.equals(other.nomeInfo))
			return false;
		if (codigoInformatica != other.codigoInformatica) {
			return false;
		}
		return true;
	}

}