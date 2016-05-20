package to;

public class CursoArtesTO {
	public int id;
	private String nome;
	private String livros;
	private String dataInicio;
	private String dataTermino;
	private String horario;
	private int vagas;
	private double valor;
	private String descricaoMaterial;

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
	
}//fim da classe
