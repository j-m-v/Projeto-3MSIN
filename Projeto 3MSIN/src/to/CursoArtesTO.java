package to;

public class CursoArtesTO {
	public int codigoArtes;
	private String nomeArtes;
	private String livros;
	private String dataInicio;
	private String dataTermino;
	private String horarioPrevisto;
	private int numeroVagas;
	private double valorCurso;
	private String descricaoMaterial;

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
	
}//fim da classe
