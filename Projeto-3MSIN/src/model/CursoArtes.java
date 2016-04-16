package model;


import dao.CursoArtesDAO;
import to.CursoArtesTO;

public class CursoArtes {
	public int codigoArtes;
	private String nomeArtes;
	private String livros;
	private String dataInicio;
	private String dataTermino;
	private String horarioPrevisto;
	private int numeroVagas;
	private double valorCurso;
	private String descricaoMaterial;

	public CursoArtes() {

		codigoArtes = 0;
		nomeArtes = "";
		livros = "";
		dataInicio = "";
		dataTermino = "";
		horarioPrevisto = "";
		numeroVagas = 0;
		valorCurso = 0.0;
		descricaoMaterial = "";
	}

	public CursoArtes(int codigo, String nomeArtes, String dataInicio, String dataTermino, String horarioPrevisto,
			int numeroVagas, double valorCurso, String livros, String descMaterial) {
		this.codigoArtes = codigo;
		this.nomeArtes = nomeArtes;
		this.livros = livros;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horarioPrevisto = horarioPrevisto;
		this.numeroVagas = numeroVagas;
		this.valorCurso = valorCurso;
		this.descricaoMaterial = descMaterial;
	}

	public CursoArtes(String nomArtes, String livros, String dataInicio, String dataTermino, String horarioPrevisto,
			int numeroVagas, double valorCurso, String descMaterial) {

		this.nomeArtes = nomArtes;
		this.livros = livros;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horarioPrevisto = horarioPrevisto;
		this.numeroVagas = numeroVagas;
		this.valorCurso = valorCurso;
		this.descricaoMaterial = descMaterial;

	}

	// MÉTODOS DE ACESSO

	public int getCodigoArtes() {
		return codigoArtes;
	}

	public String getNomeArtes() {
		return nomeArtes;
	}

	public String getLivros() {
		return livros;
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

	public String getDescricaoMaterial() {
		return descricaoMaterial;
	}

	// MODIFICADORES
	public void setCodigoArtes(int codigoArtes) {
		this.codigoArtes = codigoArtes;
	}

	public void setNomeArtes(String nomeArtes) {
		this.nomeArtes = nomeArtes;
	}

	public void setLivros(String livros) {
		this.livros = livros;
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

	public void setNumeroVagas(int vagas) {
		this.numeroVagas = vagas;
	}

	public void setValorCurso(double valor) {
		this.valorCurso = valor;
	}

	public void setDescricaoMaterial(String descricaoMaterial) {
		this.descricaoMaterial = descricaoMaterial;
	}

	public void incluir() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();
		to.setNomeArtes(nomeArtes);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setLivros(livros);
		to.setDescricaoMaterial(descricaoMaterial);
		dao.incluir(to);
		setCodigoArtes(to.getCodigoArtes());
	}
   
	public CursoArtesTO getTO() {
		CursoArtesTO to = new CursoArtesTO();
		to.setCodigoArtes(codigoArtes);
		to.setNomeArtes(nomeArtes);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setLivros(livros);
		to.setDescricaoMaterial(descricaoMaterial);
		return to;
	}
	public void alterar() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();
		to.setCodigoArtes(codigoArtes);
		to.setNomeArtes(nomeArtes);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorarioPrevisto(horarioPrevisto);
		to.setNumeroVagas(numeroVagas);
		to.setValorCurso(valorCurso);
		to.setLivros(livros);
		to.setDescricaoMaterial(descricaoMaterial);
		dao.alterar(to);
	}

	public void consultar() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = dao.consultar(codigoArtes);
		nomeArtes = to.getNomeArtes();
		dataInicio = to.getDataInicio();
		dataTermino = to.getDataTermino();
		horarioPrevisto = to.getHorarioPrevisto();
		numeroVagas = to.getNumeroVagas();
		valorCurso = to.getValorCurso();
		livros = to.getLivros();
		descricaoMaterial = to.getDescricaoMaterial();
	}

	public void deletar() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();
		to.setCodigoArtes(codigoArtes);
		dao.deletar(to);
	}

	public void consultarTodos() {
		CursoArtesDAO dao = new CursoArtesDAO();
		dao.consultarTodos();
	}

	public void retornarUltimoID() {
		CursoArtesDAO dao = new CursoArtesDAO();
		dao.retornarUltimoID();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoArtes other = (CursoArtes) obj;
		if (nomeArtes == null) {
			if (other.nomeArtes != null)
				return false;
		} else if (!nomeArtes.equals(other.nomeArtes))
			return false;
		if (codigoArtes != other.codigoArtes) {
			return false;
		}
		return true;
	}

}// fim da classe
