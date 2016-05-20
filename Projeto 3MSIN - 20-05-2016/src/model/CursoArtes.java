package model;




import dao.CursoArtesDAO;

import to.CursoArtesTO;


public class CursoArtes {
	public int id;
	private String nome;
	private String livros;
	private String dataInicio;
	private String dataTermino;
	private String horario;
	private int vagas;
	private double valor;
	private String descricaoMaterial;

	public CursoArtes() {

		id = 0;
		nome = "";
		livros = "";
		dataInicio = "";
		dataTermino = "";
		horario = "";
		vagas = 0;
		valor = 0.0;
		descricaoMaterial = "";
	}

	public CursoArtes(int codigo, String nomeArtes, String dataInicio, String dataTermino, String horarioPrevisto,
			int numeroVagas, double valorCurso, String livros, String descMaterial) {
		this.id = codigo;
		this.nome = nomeArtes;
		this.livros = livros;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horario = horarioPrevisto;
		this.vagas = numeroVagas;
		this.valor = valorCurso;
		this.descricaoMaterial = descMaterial;
	}

	public CursoArtes(String nomArtes, String livros, String dataInicio, String dataTermino, String horarioPrevisto,
			int numeroVagas, double valorCurso, String descMaterial) {

		this.nome = nomArtes;
		this.livros = livros;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horario = horarioPrevisto;
		this.vagas = numeroVagas;
		this.valor = valorCurso;
		this.descricaoMaterial = descMaterial;

	}

	// MÉTODOS DE ACESSO

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
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

	public String getHorario() {
		return horario;
	}

	public int getVagas() {
		return vagas;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricaoMaterial() {
		return descricaoMaterial;
	}

	// MODIFICADORES
	public void setId(int codigoArtes) {
		this.id = codigoArtes;
	}

	public void setNome(String nomeArtes) {
		this.nome = nomeArtes;
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

	public void setHorario(String horarioPrevisto) {
		this.horario = horarioPrevisto;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDescricaoMaterial(String descricaoMaterial) {
		this.descricaoMaterial = descricaoMaterial;
	}

	public void incluir() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.setLivros(livros);
		to.setDescricaoMaterial(descricaoMaterial);
		dao.incluir(to);
		setId(to.getId());
	}
   
	public CursoArtesTO getTO() {
		CursoArtesTO to = new CursoArtesTO();
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.setLivros(livros);
		to.setDescricaoMaterial(descricaoMaterial);
		return to;
	}
	public void alterar() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHorario(horario);
		to.setVagas(vagas);
		to.setValor(valor);
		to.setLivros(livros);
		to.setDescricaoMaterial(descricaoMaterial);
		dao.alterar(to);
	}

	public void consultar() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = dao.consultar(id);
		nome = to.getNome();
		dataInicio = to.getDataInicio();
		dataTermino = to.getDataTermino();
		horario = to.getHorario();
		vagas = to.getVagas();
		valor = to.getValor();
		livros = to.getLivros();
		descricaoMaterial = to.getDescricaoMaterial();
	}

	public void deletar() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = new CursoArtesTO();
		to.setId(id);
		dao.deletar(to);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoArtes other = (CursoArtes) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}// fim da classe
